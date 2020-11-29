package _4_BarracksWars.core.commands;

import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.Unit;
import _4_BarracksWars.interfaces.UnitFactory;

public class Add extends Command {

    public Add(Repository repository, UnitFactory unitFactory, String[] data) {
        super(repository, unitFactory, data);
    }

    @Override
    public String execute() {
        return addUnitCommand();
    }

    private String addUnitCommand() {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
