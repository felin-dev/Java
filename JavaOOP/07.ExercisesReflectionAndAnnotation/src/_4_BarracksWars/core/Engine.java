package _4_BarracksWars.core;

import _4_BarracksWars.core.commands.Command;
import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.Runnable;
import _4_BarracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) {
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        try {
            Class<?> commandClass = Class.forName("barracksWars.core.commands." + commandName);
            Constructor<?> ctor = commandClass.getConstructor(Repository.class, UnitFactory.class, String[].class);
            Command command = (Command) ctor.newInstance(repository, unitFactory, data);
            Method execute = commandClass.getMethod("execute");
            return (String) execute.invoke(command);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException
                | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }
}
