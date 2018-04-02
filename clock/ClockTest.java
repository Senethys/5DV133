package clock;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClockTest {

    @Test
    public void shouldCreateDisplay() throws Exception {
        new NumberDisplay(1, 2);
    }

    @Test(expected = LimitException.class)
    public void shouldThrowLimitExceptionAgain() throws Exception {
        new NumberDisplay(10,0);
    }

    @Test
    public void getValueTest() throws Exception {
        NumberDisplay n = new NumberDisplay(0, 59);
        n.increment();
        assertEquals(1, n.getValue());
    }

    @Test
    public void WrapAroundTest() throws Exception {
        NumberDisplay n = new NumberDisplay(0, 59);
        for(int i = 0; i >= 60; i++) {
            n.increment();
        }
        assertEquals(0, n.getValue());
    }


    @Test
    public void NoWrapAroundTest() throws Exception {
        NumberDisplay n = new NumberDisplay(0, 59);
        for(int i = 0; i >= 60; i++) {
            n.increment();
        }
        assertNotEquals(59, n.getValue());

    }
}