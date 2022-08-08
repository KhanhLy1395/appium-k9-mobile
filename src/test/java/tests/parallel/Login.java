package tests.parallel;

import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.models.LoginCred;
import tests.authen.authentication.LoginFlow;
import tests.testng.BaseTest;

public class Login extends BaseTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCred loginCred) {
        System.out.println("--> Session ID: " + getDriver().getSessionId());
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginCred.getUsername(), loginCred.getPassword());
        loginFlow.gotoLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginCred[] loginCredData() {
        String filePath = "/src/test/java/test_data/authen/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCred[].class);
    }

}