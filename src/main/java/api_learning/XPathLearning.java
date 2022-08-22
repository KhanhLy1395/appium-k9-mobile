package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Platform;

import java.util.List;

public class XPathLearning {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);
        try {
            // navigate to login screen
            MobileElement navLoginScreenButton = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenButton.click();


            // find Login form elements
            List<MobileElement> credFeildElems = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int EMAIL_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credFeildElems.get(EMAIL_INDEX).sendKeys("teo@sth.com");
            credFeildElems.get(PASSWORD_INDEX).sendKeys("12345678");


            // Find login info text by UI selector

            MobileElement loginInstructionsElem
                    = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstructionsElem.getText());


            // debug purpose only

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        appiumDriver.quit();
    }
}

