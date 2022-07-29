package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTestWithDataProvider {

    @Test(dataProvider = "loginCredData")
            public void testLogin(LoginCred loginCred){
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, loginCred.getUsername(), loginCred.getPassword());
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static class LoginCred {
    String username;
    String password;

    public LoginCred(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginCred{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

    @DataProvider
    public LoginCred[] loginCredData(){
        LoginCred data1 = new LoginCred("teo@", "12345678");
        LoginCred data2 = new LoginCred("teo@sth.com", "1111");
        LoginCred data3 = new LoginCred("teo@sth.com", "12345678");
        return new LoginCred[]{data1, data2, data3};
    }
}

