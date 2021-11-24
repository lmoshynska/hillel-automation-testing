package SelenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import fe.Pages.CitrusPages.CitrusProductListingPage;
import fe.Pages.CitrusPages.CitrusMainPage;
import fe.Pages.CitrusPages.CitrusProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CitrusTest {

    String category = "Смартфоны";
    String producer = "Apple";
    String searchItem = "Apple iPhone 12 Pro Max 128GB Pacific Blue";

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "https://www.citrus.ua";
    }

    @Test
    public void addItemToCartViaMenu() {

        CitrusMainPage mainPage = new CitrusMainPage();
        CitrusProductListingPage productListingPage;
        CitrusProductPage productPage;

        productListingPage = mainPage.open().closeAdPopup()
                .hoverOverCategory(category)
                .chooseByProducer(producer);

        productListingPage.shouldHaveProductTitle(searchItem);
        String productPrice = productListingPage.getProductPrice(searchItem);
        productPage = productListingPage.clickProduct(searchItem);

        productPage.shouldHaveProductTitle(searchItem)
                .shouldHaveProductPrice(productPrice)
                .clickBuyButton()
                .getAddedProductFragment()
                .shouldHaveProductTitle(searchItem)
                .closeAddedProductModal();

        productPage.getBasketFragment().openBasket()
                .shouldHaveProductsQuantity(1)
                .printProductTitles();
        productPage.getBasketFragment()
                .shouldHaveProductTitle(searchItem)
                .shouldHaveProductPrice(searchItem, productPrice)
                .shouldHaveProductTotal(searchItem)
                .shouldHaveItemQuantity(searchItem, "1")
                .shouldHaveBasketTotalCost();

    }
}
