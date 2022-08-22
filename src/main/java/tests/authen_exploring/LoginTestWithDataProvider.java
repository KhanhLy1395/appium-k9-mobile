package tests.authen_exploring;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import platform.Platform;
import test_data.models.LoginCred;
import test_flows.authen.LoginFlow;


public class LoginTestWithDataProvider {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCred loginCred) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getUsername(), loginCred.getPassword());
            loginFlow.gotoLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    @DataProvider
    public LoginCred[] loginCredData(){
        LoginCred data1 = new LoginCred("teo@", "12345678");
        LoginCred data2 = new LoginCred("teo@sth.com", "1111");
        LoginCred data3 = new LoginCred("teo@sth.com", "12345678");
        return new LoginCred[]{data1, data2, data3};
    }
}