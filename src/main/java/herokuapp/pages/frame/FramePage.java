package herokuapp.pages.frame;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/nested_frames']")
    WebElement nestedFramesLink;
    public NestedFramesPage selectNestedFrames() {
        click(nestedFramesLink);
        return new NestedFramesPage(driver);
    }

    @FindBy(css = "a[href='/iframe']")
    WebElement iFrameLink;
    public IFramePage selectIFrame() {
        click(iFrameLink);
        return new IFramePage(driver);
    }
}
