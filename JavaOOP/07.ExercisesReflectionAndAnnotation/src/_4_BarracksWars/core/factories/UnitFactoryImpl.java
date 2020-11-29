package _4_BarracksWars.core.factories;

import _4_BarracksWars.interfaces.Unit;
import _4_BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class<?> aClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            return (Unit) aClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
