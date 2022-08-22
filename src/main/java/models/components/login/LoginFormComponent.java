package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By usernameSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By correctLoginTxtSel = MobileBy.xpath("//*[contains(@text, 'You are logged in!')]");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        // Thời gian tối đa khi Findby PageFactory(10s)
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }


    public String getCorrectLoginStr() {
        return appiumDriver.findElement(correctLoginTxtSel).getText();
    }

    @Step("Input password as {usernameTxt}")
    public void inputUsername(String usernameTxt) {
        if (!usernameTxt.isEmpty()) {
            MobileElement userNameElem = appiumDriver.findElement(usernameSel);
            userNameElem.clear();
            userNameElem.sendKeys(usernameTxt);

        }
    }

    @AndroidFindBy(xpath= "//*[contains(@text, 'Please enter a valid email address')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter a valid email address\"")
    private MobileElement incorrectEmailTxtElem;

    public String getInvalidEmailStr() {
        return incorrectEmailTxtElem.getText().trim();
    }

    @AndroidFindBy(xpath= "//*[contains(@text, 'Please enter at least 8 characters')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter at least 8 characters\"")
    private MobileElement incorrectPasswordTxtElem;
    public String getInvalidPasswordStr() {
        return incorrectPasswordTxtElem.getText().trim();
    }

    @Step("Input password as {passwordTxt}")
    public void inputPassword(String passwordTxt) {
        if (!passwordTxt.isEmpty()) {
            MobileElement passwordElem = appiumDriver.findElement(passwordSel);
            passwordElem.clear();
            passwordElem.sendKeys(passwordTxt);
        }
    }

    @Step("Click on login button")
    public void clickOnLoginBtn() {
        appiumDriver.findElement(loginBtnSel).click();
    }

}