package _4_BarracksWars;

import _4_BarracksWars.core.Engine;
import _4_BarracksWars.core.factories.UnitFactoryImpl;
import _4_BarracksWars.data.UnitRepository;
import _4_BarracksWars.interfaces.Repository;
import _4_BarracksWars.interfaces.Runnable;
import _4_BarracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
