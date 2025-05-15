package herokuapp.tests.frame;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.frame.FramePage;
import herokuapp.pages.frame.NestedFramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).selectFramesLink();
    }

    @Test
    public void nestedFramesTest() {
        new FramePage(app.driver).selectNestedFrames();
        new NestedFramesPage(app.driver)
                .verifyCountFrames(5)
                .verifyFrameByText("MIDDLE");
    }


}
