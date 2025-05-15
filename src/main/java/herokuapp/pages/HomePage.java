package herokuapp.pages;

import herokuapp.core.BasePage;
import herokuapp.pages.frame.FramePage;
import herokuapp.pages.widgets.ContextMenuPage;
import herokuapp.pages.widgets.HoverPage;
import herokuapp.pages.widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    WebElement loginLink;

    public LoginPage selectLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement javaScriptAlertsLink;

    public HomePage selectJavaScriptAlertsLink() {
        click(javaScriptAlertsLink);
        return this;
    }

    @FindBy(css = "a[href='/frames']")
    WebElement framesLink;
    public FramePage selectFramesLink() {
        click(framesLink);
        return new FramePage(driver);
    }

    @FindBy(css = "a[href='/horizontal_slider']")
    WebElement sliderLink;
    public SliderPage selectSliderLink() {
        click(sliderLink);
        return new SliderPage(driver);
    }

    @FindBy(css = "a[href='/hovers']")
    WebElement hoversLink;
    public HoverPage selectHoversLink() {
        click(hoversLink);
        return new HoverPage(driver);
    }

    @FindBy(css = "a[href='/context_menu']")
    WebElement contextMenuLink;
    public ContextMenuPage selectContextMenuLink() {
        click(contextMenuLink);
        return new ContextMenuPage(driver);
    }
}
