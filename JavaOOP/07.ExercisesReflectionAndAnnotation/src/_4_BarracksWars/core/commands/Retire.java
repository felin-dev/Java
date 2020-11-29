package _4_BarracksWars.core.commands;

import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.UnitFactory;

public class Retire extends Command {

    public Retire(Repository repository, UnitFactory unitFactory, String[] data) {
        super(repository, unitFactory, data);
    }

    @Override
    public String execute() {
        return retireUnitCommand();
    }

    private String retireUnitCommand() {
        try {
            String unitType = super.getData()[1];
            super.getRepository().removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    }
}
