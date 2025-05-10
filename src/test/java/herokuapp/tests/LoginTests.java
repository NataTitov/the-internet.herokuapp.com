package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.LoginPage;
import herokuapp.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).selectLoginLink();

    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("tomsmith", "SuperSecretPassword!")
                .clickLoginButton()
                .verifySuccessLogin();
    }

    @Test(dataProvider = "loginNegativeTest", dataProviderClass = DataProviders.class)
    public void loginNegativeTest(String userName, String password) {
        new LoginPage(app.driver)
                .enterPersonalData(userName, password)
                .clickLoginButtonNegativeTest()
                .isCloseErrorMessageElementPresent()
                .isErrrorTextPresent("invalid");

    }

}
