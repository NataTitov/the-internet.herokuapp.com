package herokuapp.tests.widgets;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.widgets.ContextMenuPage;
import herokuapp.pages.widgets.HoverPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).selectContextMenuLink();
    }

    @Test
    public void contextMenuTest() {
        new ContextMenuPage(app.driver)
                .rightClickInTheElement()
                .verifyAllertText("You selected a context menu");
    }



}
