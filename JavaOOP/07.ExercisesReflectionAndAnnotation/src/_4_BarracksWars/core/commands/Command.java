package _4_BarracksWars.core.commands;

import _4_BarracksWars.interfaces.Executable;
import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private final Repository repository;
    private final UnitFactory unitFactory;
    private final String[] data;

    protected Command(Repository repository, UnitFactory unitFactory, String[] data) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.data = data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }

    protected String[] getData() {
        return data;
    }
}
