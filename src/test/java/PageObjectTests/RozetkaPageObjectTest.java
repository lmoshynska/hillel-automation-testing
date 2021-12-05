package PageObjectTests;

import UIDemoTests.UIBaseTest;
import fe.Pages.RozetkaPageObjectPages.RozetkaMainPage;
import fe.Pages.RozetkaPageObjectPages.RozetkaProductDetailsPage;
import fe.Pages.RozetkaPageObjectPages.RozetkaProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaPageObjectTest extends UIBaseTest {

    String searchText = "Xbox Series X 1Tb";
    RozetkaMainPage rozetkaMainPage;
    RozetkaProductsPage productsPage;
    RozetkaProductDetailsPage productDetailsPage;

    @Test(groups = {"regression", "ui_tests"})
    public void testAddingProductToCart() {
        driver.get("https://rozetka.com.ua/");

        rozetkaMainPage = new RozetkaMainPage(driver);
        productsPage = rozetkaMainPage.performSearch(searchText);

        productDetailsPage = productsPage.clickProductTitle();

        String actualProductTitle = productDetailsPage.getProductTitleText();
        Assert.assertTrue(actualProductTitle.toLowerCase().contains(searchText.toLowerCase()));

        productDetailsPage.addProductToCart();

        Assert.assertFalse(productDetailsPage.isCartEmpty());
        Assert.assertEquals(productDetailsPage.getCartLabelText(), "1");
    }
}
