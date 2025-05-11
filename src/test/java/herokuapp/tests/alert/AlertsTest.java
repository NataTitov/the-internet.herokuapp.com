package herokuapp.tests.alert;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.alerts.JavaScriptAlerts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).selectJavaScriptAlertsLink();
    }

    @Test
    public void jsAlertTest() {
        new JavaScriptAlerts(app.driver)
                .jsAlert()
                .verifyAlertResult("You successfully clicked an alert");
    }
    @Test
    public void jsConfirmClickOkTest() {
        new JavaScriptAlerts(app.driver)
                .jsConfirmClickOk()
                .verifyAlertResult("You clicked: Ok");
    }

    @Test
    public void jsConfirmClickCancelTest() {
        new JavaScriptAlerts(app.driver)
                .jsConfirmClickCancel()
                .verifyAlertResult("You clicked: Cancel");
    }

    @Test
    public void jsPromptClickOkWithTextTest() {
        new JavaScriptAlerts(app.driver)
                .jsPromptClickOkWithText()
                .verifyAlertResult("You entered: test");
    }
    @Test
    public void jsPromptClickOkWithoutTextTest() {
        new JavaScriptAlerts(app.driver)
                .jsPromptClickOkWithoutText()
                .verifyAlertResult("You entered:");
    }
    @Test
    public void jsPromptClickCancelTest() {
        new JavaScriptAlerts(app.driver)
                .jsPromptClickCancel()
                .verifyAlertResult("You entered: null");
    }
}
