package herokuapp.tests.widgets;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.widgets.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).selectSliderLink();
    }

    @Test
    public void sliderTest() {
        new SliderPage(app.driver)
                .moveSliderInHorizontalDirection()
                .verifySliderValue("2.5");
    }
}
