package herokuapp.core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);

    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        click(element);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }

    }

    public void type(WebElement element, String text, int y) {
        if (text != null) {
            click(element, 0, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isElementClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
