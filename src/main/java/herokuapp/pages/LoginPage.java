package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement passwordField;

    public LoginPage enterPersonalData(String userName, String password) {
        type(userNameField, userName);
        type(passwordField, password);
        return this;
    }

    @FindBy(css = ".radius")
    WebElement loginButton;

    public SecurePage clickLoginButton() {
        click(loginButton);
        return new SecurePage(driver);
    }

    public LoginPage clickLoginButtonNegativeTest() {
        click(loginButton);
        return this;
    }

    @FindBy(css = ".close")
    WebElement closeErrorMessage;

    public LoginPage isCloseErrorMessageElementPresent() {
        Assert.assertTrue(isElementClickable(closeErrorMessage, 10));
        return this;
    }

    @FindBy(id = "flash")
    WebElement errorText;

    public LoginPage isErrrorTextPresent(String text) {
        Assert.assertTrue(shouldHaveText(errorText, text, 5));
        return this;
    }

}
