package isp.lab4.exercise2;

import junit.framework.TestCase;

public class SmartWatchTest extends TestCase {

    public void testGetBatteryLevel() {
        SmartWatch watch1 = new SmartWatch(44);
        watch1.charge(3);
        assertEquals(76,watch1.getBatteryLevel());
    }
}