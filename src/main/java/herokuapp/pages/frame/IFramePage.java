package herokuapp.pages.frame;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IFramePage extends BasePage {
    public IFramePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@aria-label='Close']")
    WebElement closeMessage;
    @FindBy(id = "tinymce")
    WebElement textIFrame;

    public IFramePage verifyIFrameByText(String text) {
        click(closeMessage);
        driver.switchTo().frame(0);
        Assert.assertTrue(shouldHaveText(textIFrame, text, 5));
        return this;
    }
}
