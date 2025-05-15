package herokuapp.pages.widgets;

import herokuapp.core.BasePage;
import herokuapp.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.*;

public class HoverPage extends BasePage {
    public HoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='figure'][1]")
    WebElement figure1;
    public HoverPage moveMouseToFirstFigure() {
        Actions action = new Actions(driver);
        action.moveToElement(figure1).build().perform();
        return this;
    }


    public HomePage verifyHoverTitle(String text) {
        Assert.assertTrue(shouldHaveText(figure1, text, 5));
        return new HomePage(driver);
    }


}
