package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By loginIconSel = MobileBy.AccessibilityId("Login");
    private final static By formsIconSel = MobileBy.AccessibilityId("Forms");
    private final static By dragIconSel = MobileBy.AccessibilityId("Drag");
    private final static By swipeIconSel = MobileBy.AccessibilityId("Swipe");
    private final static By webviewIconSel = MobileBy.AccessibilityId("Webview");

    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnLoginIcon(){
        appiumDriver.findElement(loginIconSel).click();
    }

    public void clickOnFormsIcon() {
        appiumDriver.findElement(formsIconSel).click();
    }

    public void clickOnWebViewIcon() {
        appiumDriver.findElement(webviewIconSel).click();
    }

     public void clickOnSwipeIcon() {
        appiumDriver.findElement(swipeIconSel).click();
    }

     public void clickOnDragIcon() {
        appiumDriver.findElement(dragIconSel).click();
    }


}