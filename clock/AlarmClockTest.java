
package clock;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmClockTest {


    final int testIncrementTimes = 120;

    @Test
    public void shouldCreateAlarmClock() throws Exception {
        Clock n = new AlarmClock();
    }

    @Test(expected = LimitException.class)
    public void shouldThrowLimitExceptionHours() throws Exception {
        Clock n = new AlarmClock(32, 23);
    }

    @Test(expected = LimitException.class)
    public void shouldThrowLimitExceptionMinutes() throws Exception {
        Clock n = new AlarmClock(2, -23);
    }


    @Test
    public void initialStateTest() throws Exception {
        Clock n = new AlarmClock();
        assertEquals("00:00", n.getTime());
    }


    @Test
    public void setAlarmTimeTest() throws Exception {
        AlarmClock n = new AlarmClock();
        n.setAlarm(13,37);
        n.setTime(13,36);
        assertFalse(n.isTriggered());
        n.timeTick();
        System.out.println(n.getTime());
        assertTrue(n.isTriggered());
        n.timeTick();
        System.out.println(n.getTime());
        assertFalse(n.isTriggered());

    }


    @Test
    public void alarmSwitchTest() throws Exception {
        AlarmClock n = new AlarmClock();
        n.setAlarm(13,37);
        n.turnOff();
        n.setTime(13,36);
        assertFalse(n.isTriggered());
        n.timeTick();
        System.out.println(n.getTime());
        assertFalse(n.isTriggered());

        n.setAlarm(13,37);
        n.setTime(13,36);
        n.timeTick();
        assertTrue(n.isTriggered());
    }
}
