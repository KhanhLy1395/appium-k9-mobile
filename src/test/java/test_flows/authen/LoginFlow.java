package test_flows.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.login.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
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

    @Step("Verify login with correct creds")
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

    @Step("Verify login with correct creds")
    private void verifyCorrectLoginCreds() {

        String actualValidLoginStr = loginFormComponent.getCorrectLoginStr();
        String expectedValidLoginStr = "You are logged in!";
        Assert.assertEquals(actualValidLoginStr, expectedValidLoginStr, "Login Failed");

        System.out.println("actualValidLoginStr: " + actualValidLoginStr);
        System.out.println("expectedValidLoginStr: " + expectedValidLoginStr);
    }

    @Step("Verify login with incorrect email")
    private void verifyIncorrectEmail(LoginFormComponent loginFormComponent) {

        String actualInvalidPasswordStr = loginFormComponent.getInvalidEmailStr();
        String expectedInvalidPasswordStr = "Please enter a valid email address";
        Assert.assertEquals(actualInvalidPasswordStr, expectedInvalidPasswordStr, "Email invalid");

        System.out.println("actualInvalidPasswordStr: " + actualInvalidPasswordStr);
        System.out.println("expectedInvalidPasswordStr: " + expectedInvalidPasswordStr);
    }

    @Step("Verify login with incorrect password")
    private void verifyIncorrectPassword(LoginFormComponent loginFormComponent) {
        String actualInvalidPasswordStr = loginFormComponent.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";
        Assert.assertEquals(actualInvalidPasswordStr, expectedInvalidPasswordStr, "Password invalid");

        System.out.println("actualInvalidPasswordStr: " + actualInvalidPasswordStr);
        System.out.println("expectedInvalidPasswordStr: " + expectedInvalidPasswordStr);
    }

}
