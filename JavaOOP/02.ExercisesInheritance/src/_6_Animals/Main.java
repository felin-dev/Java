package _6_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = reader.readLine()).equals("Beast!")) {

            switch (input) {
                case "Dog": {
                    try {
                        String[] tasks = reader.readLine().split(" ");
                        Dog dog = new Dog(tasks[0], Integer.parseInt(tasks[1]), tasks[2]);
                        System.out.println(dog.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "Frog": {
                    try {
                        String[] tasks = reader.readLine().split(" ");
                        Frog frog = new Frog(tasks[0], Integer.parseInt(tasks[1]), tasks[2]);
                        System.out.println(frog.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "Cat": {
                    try {
                        String[] tasks = reader.readLine().split(" ");
                        Cat cat = new Cat(tasks[0], Integer.parseInt(tasks[1]), tasks[2]);
                        System.out.println(cat.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "Tomcat": {
                    try {
                        String[] tasks = reader.readLine().split(" ");
                        Tomcat tomcat;
                        if (tasks.length == 3) {
                            tomcat = new Tomcat(tasks[0], Integer.parseInt(tasks[1]), tasks[2]);
                        } else {
                            tomcat = new Tomcat(tasks[0], Integer.parseInt(tasks[1]));
                        }
                        System.out.println(tomcat.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "Kitten": {
                    try {
                        String[] tasks = reader.readLine().split(" ");
                        Kitten kitten;
                        if (tasks.length == 3) {
                            kitten = new Kitten(tasks[0], Integer.parseInt(tasks[1]), tasks[2]);
                        } else {
                            kitten = new Kitten(tasks[0], Integer.parseInt(tasks[1]));
                        }
                        System.out.println(kitten.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
        }
    }
}
