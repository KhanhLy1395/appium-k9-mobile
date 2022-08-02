package tests.authen.authentication;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.models.LoginCred;
import test_flows.BaseFlow;
import tests.testng.BaseTest;

public class LoginTestWithBaseTest extends BaseTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCred loginCred) {

        initAppiumSession();
            LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getUsername(), loginCred.getPassword());
            loginFlow.gotoLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();
       closeAppiumSession();

    }

    @DataProvider
    public LoginCred[] loginCredData(){
        LoginCred data1 = new LoginCred("teo@", "12345678");
        LoginCred data2 = new LoginCred("teo@sth.com", "1111");
        LoginCred data3 = new LoginCred("teo@sth.com", "12345678");
        return new LoginCred[]{data1, data2, data3};
    }

}
