package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

import java.util.List;

public class XPathLearning {

    public static void main(String[] args) {

        try {
            AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

            // navigate to Login screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            List<MobileElement> credFieldsElem = appiumDriver.findElements(MobileBy.xpath(""));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credFieldsElem.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credFieldsElem.get(PASSWORD_INDEX).sendKeys("12345678");

            // Find login info text by UISelector
            MobileElement loginInstructionElem =
                    appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UISelector().textContains(\"When the device\")"));
            System.out.println(loginInstructionElem.getText());
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
