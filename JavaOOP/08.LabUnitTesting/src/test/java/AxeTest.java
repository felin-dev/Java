package rpg_lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class AxeTest {

    private final Axe axe = new Axe(10, 10);
    private final Target target = mock(Target.class);

    @Test
    public void testTheAxeGetterForAttackPoints() {
        assertEquals(10, axe.getAttackPoints());
    }

    @Test
    public void testTheAxeGetterForDurability() {
        assertEquals(10, axe.getDurabilityPoints());
    }

    @Test
    public void testAttackWithAxeWithZeroOrNegativeDurabilityExceptionIsThrown() {
        Axe axeWithZeroDurability = new Axe(5, 0);
        assertThrows(
                IllegalStateException.class,
                () -> axeWithZeroDurability.attack(target));
    }

    @Test
    public void testAfterAttackTheAxeLosesDurability() {
        axe.attack(target);
        assertEquals(9, axe.getDurabilityPoints());
    }
}
