package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class DummyTest {

    private ItemStorage itemStorage;
    private Target target;
    private Weapon weapon;

    @BeforeEach
    public void setUp() {
        itemStorage = new ItemRepository(List.of(new Axe(3, 3), new Axe(4, 4)));
        target = new Dummy(10, 10, itemStorage);
        weapon = new Axe(5, 10);
    }

    @Test
    public void testDummyGetterForHp() {
        assertEquals(10, target.getHealth());
    }

    @Test
    public void testAttackingDeadDummyShouldThrowException() {
        weapon.attack(target);
        weapon.attack(target);
        assertThrows(IllegalStateException.class, () -> weapon.attack(target));
    }

    @Test
    public void testAttackedDummyLosesHealth() {
        weapon.attack(target);
        assertEquals(5, target.getHealth());
    }

    @Test
    public void testDummyThrowsExceptionForGivingExperienceWithoutBeingDead() {
        weapon.attack(target);
        assertThrows(IllegalStateException.class, target::giveExperience);
    }

    @Test
    public void testDummyGivesExperienceAfterBeingKilled() {
        weapon.attack(target);
        weapon.attack(target);
        assertEquals(10, target.giveExperience());
    }

    @Test
    public void testDummyDropsTheCorrectWeapon() {
        Random random = mock(Random.class);
        int randomIndex = 1;
        doReturn(randomIndex).when(random).nextInt(anyInt());

        ArrayList<Weapon> weapons = new ArrayList<>(itemStorage.getWeapons());

        Weapon weapon = target.dropWeapon(random);

        Weapon weaponTest = weapons.get(randomIndex);

        assertEquals(weaponTest, weapon);
    }
}
