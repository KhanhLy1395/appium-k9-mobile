# appium-k9-mobile

## Command to build
```
mvn clean package -DskipTests=true
```

## Command to run
* Remove all allure-re* folders
* Execute command
```
java -Dplatform=android/ios -Dremote=true/fasle -jar target/appium-k9-mobile-1.0-SNAPSHOT-fat-tests.jar
```

# Exercise WebdriverIO app
## Home Page
* HomePage_001: Make sure "App purpose" displayed
* HomePage_002: Make sure "Support" channel displayed

## Login
* Login_001: Make sure "missing email and password" displayed
* Login_002: Make sure "missing email" displayed
* Login_003: Make sure "missing password" displayed
* Login_004: User can login with correct creds

## Form
* Form_001: what user input can be displayed
* Form_002: user can switch on/off and text displayed
* Form_003: user can switch on/off and text displayed
* Form_004: user can select dropdown webdriverio/appium/this app is awesome
* Form_005: Active/Inactive button works properly

## Swipe
* Swipe_001: User can swipe and texts are displayed correctly
* Swipe_002: Swipe vertically to see the icon at the end

## Webview
* Make sure the menu text and hyperlink displayed correctly


# SDETPRO e-commerce app
## App info

```
appPackage: com.tuhuynh.sdetproecommerce
accActivity: host.exp.exponent.MainActivity
```

## Sample checklist
You can base on below checklist to automate the app

### Registration
* Make sure user can register an account: msg displayed, user is navigated to login screen

### Authentication
* User can login with correct creds
* There is a msg when use login with incorrect

### General UI
* Categories not empty
* Item list is not empty
* Item details correct

### Buying items
* Make sure user can cancel order before submit
* Make sure user can oder one or more items


## Download App
Please go to: https://github.com/sdetpro-blog/sdetpro-shop-app/releases

