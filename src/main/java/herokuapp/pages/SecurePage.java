package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SecurePage extends BasePage {
    public SecurePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".button.secondary.radius")
    WebElement logOutButton;

    public SecurePage verifySuccessLogin() {
        Assert.assertTrue(isElementClickable(logOutButton, 5));
        return this;
    }


}
