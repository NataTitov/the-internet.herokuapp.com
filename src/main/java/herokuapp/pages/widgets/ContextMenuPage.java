package herokuapp.pages.widgets;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "hot-spot")
WebElement hotSpot;
    public ContextMenuPage rightClickInTheElement() {
        Actions action = new Actions(driver);
        action.moveToElement(hotSpot).build().perform();
        action.contextClick(hotSpot).perform();
        return this;
    }

    public ContextMenuPage verifyAllertText(String text) {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, text);
        driver.switchTo().alert().accept();
        return this;
    }
}
