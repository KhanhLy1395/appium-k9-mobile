package tests;

import com.google.common.reflect.ClassPath;
import driver.MobileCapabilityTypeEx;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import platform.Platform;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

public class Main implements MobileCapabilityTypeEx {

    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) throws IOException {

        // Get all classes
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> testClasses = new ArrayList<>();

         for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoName = info.getName();
            boolean startWithTestDot = classInfoName.startsWith("tests.");
            boolean isBaseTestClass = classInfoName.startsWith("tests.BaseTest");
            boolean isMainClass = classInfoName.startsWith("tests.Main");

            if (startWithTestDot && !isMainClass && !isBaseTestClass){
                testClasses.add(info.load());
            }
        }

        // Get platform
        //String platFormName = System.getProperty("platform");
        String platFormName = System.getenv("platform");
        if (platFormName == null){
            throw new IllegalArgumentException("[ERR] Please provide platform via -Dplatform");
        }

        try {
            Platform.valueOf(platFormName);
        } catch (Exception e){
            throw new IllegalArgumentException("[ERR] We don't support platform " + platFormName + ", supported platform: " + Arrays.toString(Platform.values()));
        }

        //Device under test
        List<String> iphoneDevicesList = Arrays.asList("iPhone 12", "iPhone 13");
        List<String> androidDevicesList = Arrays.asList("emulator-5554", "9b776ad1");
        List<String> deviceList = platFormName.equalsIgnoreCase("ios") ? iphoneDevicesList : androidDevicesList;

        // Assign test class into devices
        final int testNumEachDevice = testClasses.size() / deviceList.size();
        Map<String, List<Class<?>>> desiredCaps = new HashMap<>();

        for (int deviceIndex = 0; deviceIndex < deviceList.size(); deviceIndex++) {
            int startIndex = deviceIndex * testNumEachDevice;
            boolean isTheLastDevice = deviceIndex == deviceList.size() -1;
            int endIndex = isTheLastDevice ? testClasses.size() : (startIndex + testNumEachDevice);
            List<Class<?>> subTestList = testClasses.subList(startIndex, endIndex);
            desiredCaps.put(deviceList.get(deviceIndex), subTestList);
        }

        // Build dynamic test suite
        TestNG testNG = new TestNG();
            // Tao Suite
        XmlSuite suite = new XmlSuite();
            // Dat ten Suite
        suite.setName("Regression");

        List<XmlTest> allTests = new ArrayList<>();
        // Loop all device
        for (String deviceName : desiredCaps.keySet()) {
            // tao 1 <test>
            XmlTest test = new XmlTest(suite);
            // dat ten cho <test>
            test.setName(deviceName );
            // List xml class
            List<XmlClass> xmlClasses = new ArrayList<>();
            // List những class đã đc gán cho device đó
            List<Class<?>> dedicatedClasses = desiredCaps.get(deviceName);
            for (Class<?> dedicatedClass : dedicatedClasses) {
                xmlClasses.add(new XmlClass(dedicatedClass.getName()));
            }
            // add vao test
            test.setXmlClasses(xmlClasses);
            // add them parameter(udid,...)
            test.addParameter(UDID, deviceName);
            test.addParameter(PLATFORM_NAME, platFormName);
            test.addParameter(PLATFORM_VERSION, "15.0");
            test.addParameter(SYSTEM_PORT, String.valueOf(new SecureRandom().nextInt(1000) + 8300));
            allTests.add(test);
        }

        suite.setTests(allTests);
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setThreadCount(10);

        System.out.println(suite.toXml());

        // Add testsuite into suite list
        /*List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);*/

        // Invoke run method
        /*testNG.setXmlSuites(suites);
        testNG.run();*/




    }
}
