package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.component.login.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    LoginScreen loginScreen = new LoginScreen(appiumDriver);
    LoginFormComponent loginFormComponent = loginScreen.loginFormComp();
    private final String username;
    private final String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComp();
        if (!username.isEmpty()) {
            loginFormComp.inputUsername(username);
        }

        if (!password.isEmpty()) {
            loginFormComp.inputPassword(password);
        }

        loginFormComp.clickOnLoginBtn();
    }

    public void verifyLogin() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(username);
        boolean isPasswordValid = password.length() >= 8;

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds();
        }
        if (!isEmailValid) {
            verifyIncorrectEmail(loginFormComponent);
        }
        if (!isPasswordValid) {
            verifyIncorrectPassword(loginFormComponent);
        }

    }

    // todo
    private void verifyCorrectLoginCreds() {

    }

    private void verifyIncorrectEmail(LoginFormComponent loginFormComponent) {
        String actualInvalidEmailStr = loginFormComponent.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address";

        System.out.println("actualInvalidEmailStr: " + actualInvalidEmailStr);
        System.out.println("expectedInvalidEmailStr: " + expectedInvalidEmailStr);
    }

    private void verifyIncorrectPassword(LoginFormComponent loginFormComponent) {
        String actualInvalidPasswordStr = loginFormComponent.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 character";

        System.out.println("actualInvalidPasswordStr: " + actualInvalidPasswordStr);
        System.out.println("expectedInvalidPasswordStr: " + expectedInvalidPasswordStr);
    }

}
