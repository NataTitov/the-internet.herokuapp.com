package herokuapp.pages.widgets;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='range']")
    WebElement slider;
    public SliderPage moveSliderInHorizontalDirection() {
        new Actions(driver).dragAndDropBy(slider, 3, 0).perform();
        return this;
    }

    public SliderPage verifySliderValue(String number) {
        Assert.assertEquals(slider.getAttribute("value"), number);
        return this;
    }
}
