package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

    private Weapon weapon;
    private Target target;
    private Hero hero;

    @BeforeEach
    public void setUp() {
        weapon = new Axe(5, 10);
        ItemStorage itemStorage = new ItemRepository(
                List.of(new Axe(3, 3),
                        new Axe(4, 4)));
        target = new Dummy(10, 10, itemStorage);
        hero = new Hero("Ancient", weapon);
    }

    @Test
    public void testHeroGettingTheCorrectWeapon() {
        assertEquals(weapon, hero.getWeapon());
    }

    @Test
    public void testHeroGetterForName() {
        assertEquals("Ancient", hero.getName());
    }

    @Test
    public void testHeroGainsExperienceAfterKillingTarget() {
        hero.attack(target);
        hero.attack(target);
        assertEquals(10, hero.getExperience());
    }

    @Test
    public void testHeroDealsDamage() {
        hero.attack(target);
        assertEquals(5, target.getHealth());
    }
}
