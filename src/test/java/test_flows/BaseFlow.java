package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreen;
import tests.testng.BaseTest;

public class BaseFlow {

    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void gotoLoginScreen() {
        new LoginScreen(appiumDriver).bottomNavComp().clickOnLoginIcon();
    }
}
