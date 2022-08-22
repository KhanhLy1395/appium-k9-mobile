package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import platform.Platform;

import java.io.File;

public class TakingScreenshot {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {

            // navigate to login screen
            MobileElement navLoginScreenButton = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenButton.click();

            // Whole screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE); // từ appium getscreenshot(chụp cả màn hình đt)
            String fileLocation = System.getProperty("user.dir").concat("/sreenshots/").concat("LoginScreen.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An area
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            base64ScreenshotData = loginFormElem.getScreenshotAs(OutputType.FILE); // từ 1 element getscreenshot(chụp riêng app)
            fileLocation = System.getProperty("user.dir").concat("/sreenshots/").concat("LoginForms.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An element
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            base64ScreenshotData = loginBtnElem.getScreenshotAs(OutputType.FILE); // từ 1 element getscreenshot(chụp riêng app)
            fileLocation = System.getProperty("user.dir").concat("/sreenshots/").concat("LoginBtn.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
