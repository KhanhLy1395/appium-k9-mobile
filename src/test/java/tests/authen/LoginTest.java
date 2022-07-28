package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Platform;
import test_flows.authentication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        List<LoginCred> loginCred = new ArrayList<>();
        loginCred.add(new LoginCred("teo@", "12345678"));
        loginCred.add(new LoginCred("teo@sth.com", "1234567"));
        loginCred.add(new LoginCred("teo@sth.com", "12345678"));
        try {
            for (LoginCred cred : loginCred) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, cred.getUsername(), cred.getPassword());
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }
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

    }
}
