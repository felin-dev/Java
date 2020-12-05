package rpg_lab;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemRepositoryTest {

    private ItemStorage itemStorage;

    @Test
    public void testItemStorageGetWeaponCollection() {
        List<Weapon> axes = List.of(new Axe(3, 3), new Axe(4, 4));
        itemStorage = new ItemRepository(axes);
        assertEquals(axes, itemStorage.getWeapons());
    }

    @Test
    public void testItemStorageIterator() {
        List<Weapon> axes = List.of(new Axe(3, 3), new Axe(4, 4));
        itemStorage = new ItemRepository(axes);
        Iterator<Weapon> axesIterator = axes.iterator();
        Iterator<Weapon> itemStorageIterator = itemStorage.iterator();

        while (axesIterator.hasNext()) {
            Weapon testWeapon = axesIterator.next();
            Weapon itemStorageWeapon = itemStorageIterator.next();
            assertEquals(testWeapon, itemStorageWeapon);
        }
    }
}
