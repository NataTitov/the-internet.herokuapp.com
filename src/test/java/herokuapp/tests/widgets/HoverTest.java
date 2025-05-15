package herokuapp.tests.widgets;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.widgets.HoverPage;
import herokuapp.pages.widgets.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).selectHoversLink();
    }

    @Test
    public void hoverTest() {
        new HoverPage(app.driver)
                .moveMouseToFirstFigure()
                .verifyHoverTitle("name: user1")
        ;
    }
}
