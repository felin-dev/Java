package _4_BarracksWars.core.commands;

import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.UnitFactory;

public class Fight extends Command {

    public Fight(Repository repository, UnitFactory unitFactory, String[] data) {
        super(repository, unitFactory, data);
    }

    @Override
    public String execute() {
        return fightCommand();
    }

    private String fightCommand() {
        return "fight";
    }
}
