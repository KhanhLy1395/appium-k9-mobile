package tests.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {


    @Test
    @Parameters({"udid", "systemPort"})
    public void testParameter(String device, String systemPort){
        System.out.printf("udid: %s | systemPort: %s\nl", device, systemPort);
    }
}
