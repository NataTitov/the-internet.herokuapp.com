package herokuapp.pages.frame;

import herokuapp.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public NestedFramesPage verifyCountFrames(int expected) {
        int total = countAllFrames();
        System.out.println("Total frames (including nested): " + total);
        Assert.assertEquals(total, expected);
        return this;
    }

    public int countAllFrames() {
        int count = 0;
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        count += frames.size();
        for (int i = 0; i < frames.size(); i++) {
            driver.switchTo().frame(i);
            count += countAllFrames();
            driver.switchTo().parentFrame();
        }
        return count;
    }

    @FindBy(id = "content")
    WebElement content;
    public NestedFramesPage verifyFrameByText(String text) {
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        Assert.assertTrue(shouldHaveText(content, text, 5));
        return this;
    }
}
