package UIDemoTests;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDevTest extends UIBaseTest {

    @Test
    public void driverActionsTest() {
        driver.get("https://www.google.com/");
        String googleTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        Assert.assertTrue(driver.getTitle().contains("Se"));

        driver.switchTo().window(googleTab);
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
