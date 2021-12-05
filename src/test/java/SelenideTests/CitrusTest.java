package SelenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import fe.Pages.CitrusPages.CitrusProductListingPage;
import fe.Pages.CitrusPages.CitrusMainPage;
import fe.Pages.CitrusPages.CitrusProductPage;
import fe.Steps.CitrusSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CitrusTest {

    String category = "Смартфоны";
    String producer = "Apple";
    String searchItem = "Apple iPhone 12 Pro Max 128GB Pacific Blue";

    CitrusSteps steps = new CitrusSteps();

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "https://www.citrus.ua";
    }

    @Test
    public void addItemToCartViaMenu() {

        steps.openCitrusPageAndSelectProducer(category, producer);
        String productPrice = steps.getProductPrice(searchItem);

        steps.clickProductAndVerifyInfo(searchItem, productPrice);
        steps.clickBuyButtonAndVerifyInfoInModal(searchItem);
        steps.verifyProductInfoInBasket(searchItem, productPrice);

    }
}
