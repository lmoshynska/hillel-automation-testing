package PageObjectTests;

import UIDemoPages.Pages.RozetkaPageFactoryPages.RozetkaPageFactoryMainPage;
import UIDemoPages.Pages.RozetkaPageFactoryPages.RozetkaPageFactoryProductDetailsPage;
import UIDemoPages.Pages.RozetkaPageFactoryPages.RozetkaPageFactoryProductsPage;
import UIDemoTests.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaPageFactoryTest extends UIBaseTest {

    String searchText = "Xbox Series X 1Tb";
    RozetkaPageFactoryMainPage rozetkaMainPage;
    RozetkaPageFactoryProductsPage productsPage;
    RozetkaPageFactoryProductDetailsPage productDetailsPage;

    @Test
    public void testAddingProductToCart() {
        driver.get("https://rozetka.com.ua/");

        rozetkaMainPage = new RozetkaPageFactoryMainPage(driver);
        productsPage = rozetkaMainPage.performSearch(searchText);

        productDetailsPage = productsPage.clickProductTitle();

        String actualProductTitle = productDetailsPage.getProductTitleText();
        Assert.assertTrue(actualProductTitle.toLowerCase().contains(searchText.toLowerCase()));

        productDetailsPage.addProductToCart();

        Assert.assertFalse(productDetailsPage.isCartEmpty());
        Assert.assertEquals(productDetailsPage.getCartLabelText(), "1");
    }
}
