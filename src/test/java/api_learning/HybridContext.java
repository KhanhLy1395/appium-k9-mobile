package api_learning;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {

            By webViewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webViewNavBtnElem = appiumDriver.findElement(webViewNavBtnSel);
            webViewNavBtnElem.click();

            // wait until we have on more than context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            //print all context
            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println(contextHandle);
            }

            // Switch to Webview
            appiumDriver.context(Contexts.WEB_VIEW);

            //Interact with webview element
            WebElement navToggleBtnElem = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();

            List<MobileElement> menuItemElems = appiumDriver.findElementsByCssSelector(".menu__list li a");
            Map<String, String> menuItemDataMap = new HashMap<>();
            List<MenuItemData> menuItemDataList = new ArrayList<>();

            // False negative : luon chay ca khi menuItemElems empty
            if (menuItemElems.isEmpty())
                throw new RuntimeException("[ERR] There is no list items!");
            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemDataMap.put("GitHub", itemHref); // xử lý github item
                    menuItemDataList.add(new MenuItemData("GitHub", itemHref));
                } else {
                    menuItemDataMap.put(itemText, itemHref); // xử lý các item còn lại
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                }

            }

            //Verification
            for (String itemText : menuItemDataMap.keySet()) {
                System.out.println("Item text" + itemText);
                System.out.println("Item Href" + menuItemDataMap.get(itemText));
            }

            for (MenuItemData menuItemData : menuItemDataList) {
                System.out.println("Item text" + menuItemData.getName());
                System.out.println("Item Href" + menuItemData.getHref());
            }

            // False positive | Flakiness


            //Switch back to Native context
            appiumDriver.context(Contexts.NATIVE);

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();

    }

    public static class MenuItemData {
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }
    }
}
