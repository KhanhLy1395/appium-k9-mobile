package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;

import java.time.Duration;

public class Swipe {

    public void swipeUpVertically(int swipeStep, int swipeTime){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        // Get mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Calculate touch point
        int xStartPoint = (50 * screenHeight) / 100;
        int xEndPoint = (50 * screenHeight) / 100;

        int yStartPoint = (20 * screenWidth) /100;
        int yEndPoint = (swipeStep * screenWidth) /100;

        // Convert coordinates >> point options
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        // Swipe up screen - USing touch action
        TouchAction touchAction = new TouchAction(appiumDriver);
        for (int i = 0; i < swipeTime; i++) {
            touchAction
                    .longPress(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }
    }
    public void swipeDownVertically(int swipeStep, int swipeTime){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        // Get mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Calculate touch point
        int xStartPoint = (50 * screenHeight) / 100;
        int xEndPoint = (50 * screenHeight) / 100;

        int yStartPoint = (20 * screenWidth) /100;
        int yEndPoint = (swipeStep * screenWidth) /100;

        // Convert coordinates >> point options
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        // Swipe up screen - USing touch action
        TouchAction touchAction = new TouchAction(appiumDriver);
        for (int i = 0; i < swipeTime; i++) {
            touchAction
                    .longPress(endPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(startPoint)
                    .release()
                    .perform();
        }
    }


    public void swipeRightHorizontally(int swipeStep, int swipeTime){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        // Get mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Calculate touch point
        int xStartPoint = (50 * screenHeight) / 100;
        int xEndPoint = (10 * screenHeight) / 100;

        int yStartPoint = (70 * screenWidth) /100;
        int yEndPoint = (70 * screenWidth) /100;

        // Convert coordinates >> point options
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        // Swipe up screen - USing touch action
        TouchAction touchAction = new TouchAction(appiumDriver);
        for (int i = 0; i < swipeTime; i++) {
            touchAction
                    .longPress(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }
    }

    public void swipeLeftHorizontally(int swipeStep, int swipeTime){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        // Get mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Calculate touch point
        int xStartPoint = (50 * screenHeight) / 100;
        int xEndPoint = (90 * screenHeight) / 100;

        int yStartPoint = (50 * screenWidth) /100;
        int yEndPoint = (50 * screenWidth) /100;

        // Convert coordinates >> point options
        PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

        // Swipe up screen - USing touch action
        TouchAction touchAction = new TouchAction(appiumDriver);
        for (int i = 0; i < swipeTime; i++) {
            touchAction
                    .longPress(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();
        }
    }

}
