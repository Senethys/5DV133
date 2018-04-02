package clock;
import org.junit.Test;

import static org.junit.Assert.*;


public class NumberDisplayTest {

    final int testMinLimit = 0;
    final int testMaxLimit = 59;
    final int testIncrementTimes = 120;

    @Test
    public void shouldCreateDisplay() throws Exception {
        new NumberDisplay(1, 2);
    }

    @Test(expected = LimitException.class)
    public void shouldThrowLimitExceptionAgain() throws Exception {
        new NumberDisplay(10,0);
    }

    @Test(expected = LimitException.class)
    public void shouldThrowLimitException0() throws Exception {
        new NumberDisplay(0,0);
    }


    @Test
    public void initialStateTest() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        assertEquals(testMinLimit, n.getValue());
        assertEquals("00", n.getDisplayValue());

    }

    @Test
    public void initialStateTestIncrement() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        n.increment();
        assertEquals(1, n.getValue());
        assertEquals("01", n.getDisplayValue());
    }

    @Test
    public void initialStateTestDisplayIncrement() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        assertNotEquals(1, n.getValue());
        assertNotEquals("01", n.getDisplayValue());
    }

    @Test
    public void initialStateTestNoIncrement() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        assertNotEquals(1, n.getValue());
        assertEquals("00", n.getDisplayValue());
    }

    @Test
    public void setValueTest() throws Exception {
        NumberDisplay n = new NumberDisplay(0, 59);
        n.setValue(59);
        assertEquals(59, n.getValue());
        assertEquals("59", n.getDisplayValue());
    }

    @Test
    public void WrapAroundTest() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        n.setValue(59);
        n.increment();
        n.increment();
        assertEquals(   1, n.getValue());
        assertEquals("01", n.getDisplayValue());
    }

    @Test
    public void testIncrementTimes() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        for(int i = 0; i < testIncrementTimes; i++) {
            n.increment();
        }
        assertEquals(0, n.getValue());
        assertEquals("00", n.getDisplayValue());

    }


    @Test
    public void WrapAroundTestMiddle() throws Exception {
        NumberDisplay n = new NumberDisplay(testMinLimit, testMaxLimit);
        for(int i = 0; i < testMaxLimit / 2; i++) {
            n.increment();
        }
        assertEquals(testMaxLimit / 2, n.getValue());
        assertEquals("29", n.getDisplayValue());

    }
}