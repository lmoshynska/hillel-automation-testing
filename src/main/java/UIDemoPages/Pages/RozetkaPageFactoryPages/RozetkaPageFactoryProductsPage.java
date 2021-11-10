package UIDemoPages.Pages.RozetkaPageFactoryPages;

import UIDemoPages.Pages.RozetkaPageObjectPages.RozetkaProductDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaPageFactoryProductsPage {

    WebDriver driver;

    @FindBy(css=".content_type_catalog .goods-tile__heading")
    private WebElement productTitle;

    public RozetkaPageFactoryProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaPageFactoryProductDetailsPage clickProductTitle() {
        productTitle.click();
        return new RozetkaPageFactoryProductDetailsPage(driver);
    }
}
