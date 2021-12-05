package fe.Pages.RozetkaPageFactoryPages;

import fe.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaPageFactoryProductsPage extends BasePage {

    @FindBy(css=".content_type_catalog .goods-tile__heading")
    private WebElement productTitle;

    public RozetkaPageFactoryProductsPage(WebDriver driver) {
        super(driver);
    }

    public RozetkaPageFactoryProductDetailsPage clickProductTitle() {
        productTitle.click();
        return new RozetkaPageFactoryProductDetailsPage(driver);
    }
}
