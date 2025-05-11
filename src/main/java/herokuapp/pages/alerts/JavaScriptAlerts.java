package herokuapp.pages.alerts;

import herokuapp.core.BasePage;
import herokuapp.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JavaScriptAlerts extends BasePage {
    public JavaScriptAlerts(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement jsAlertButton;

    public JavaScriptAlerts jsAlert() {
        click(jsAlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .alertIsPresent()).accept();

        return this;
    }

    @FindBy(id = "result")
    WebElement resultText;

    public JavaScriptAlerts verifyAlertResult(String text) {
        Assert.assertTrue(shouldHaveText(resultText, text, 5));
        return this;
    }

    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement jsConfirmButton;

    public JavaScriptAlerts jsConfirmClickOk() {
        click(jsConfirmButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .alertIsPresent()).accept();

        return this;
    }

    public JavaScriptAlerts jsConfirmClickCancel() {
        click(jsConfirmButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .alertIsPresent()).dismiss();

        return this;
    }

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPromptButton;

    public JavaScriptAlerts jsPromptClickOkWithText() {
        click(jsPromptButton);
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("test");
        prompt.accept();
        return this;
    }

    public JavaScriptAlerts jsPromptClickOkWithoutText() {
        click(jsPromptButton);
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("");
        prompt.accept();
        return this;
    }

    public JavaScriptAlerts jsPromptClickCancel() {
        click(jsPromptButton);
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("");
        prompt.dismiss();
        return this;
    }
}
