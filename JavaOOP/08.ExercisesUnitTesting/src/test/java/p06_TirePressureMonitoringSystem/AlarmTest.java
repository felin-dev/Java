package p06_TirePressureMonitoringSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AlarmTest {

    private Sensor sensor;
    private Alarm alarm;

    @BeforeEach
    public void setUp() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmConstructor() {
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckWithNormalPressure() {
        doReturn(17.3).when(sensor).popNextPressurePsiValue();
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckWithLowerPressure() {
        doReturn(16.3).when(sensor).popNextPressurePsiValue();
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmCheckWithHigherPressure() {
        doReturn(21.3).when(sensor).popNextPressurePsiValue();
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
}
