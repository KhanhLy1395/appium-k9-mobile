package tests.form;

import org.testng.annotations.Test;
import test_flows.form.FormFlow;
import tests.testng.BaseTest;

public class FormTest extends BaseTest {

    @Test
    public void testFormInput() {
        System.out.println("--> Session ID: " + getDriver().getSessionId());
        FormFlow formFlow = new FormFlow(getDriver());
        formFlow.gotoFormScreen();
        formFlow.fillTheForm();
        formFlow.verifyFormDisplay();
    }
}
