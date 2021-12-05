package fe.Steps;

import fe.Pages.CitrusPages.CitrusMainPage;
import fe.Pages.CitrusPages.CitrusProductListingPage;
import fe.Pages.CitrusPages.CitrusProductPage;
import io.qameta.allure.Step;

public class CitrusSteps {

    CitrusMainPage mainPage = new CitrusMainPage();
    CitrusProductListingPage productListingPage = new CitrusProductListingPage();
    CitrusProductPage productPage = new CitrusProductPage();

    @Step("Open main page then choose category and producer")
    public void openCitrusPageAndSelectProducer(String category, String producer) {
        mainPage.open().closeAdPopup()
                .hoverOverCategory(category)
                .chooseByProducer(producer);
    }

    @Step
    public String getProductPrice(String searchItem) {
        return productListingPage.getProductPrice(searchItem);
    }

    @Step("Check that correct title/price is displayed after product selection")
    public void clickProductAndVerifyInfo(String searchItem, String productPrice){
        productListingPage.clickProduct(searchItem);
        productPage.shouldHaveProductTitle(searchItem)
                .shouldHaveProductPrice(productPrice);
    }

    @Step("Click buy button and verify info in modal window")
    public void clickBuyButtonAndVerifyInfoInModal(String searchItem) {
        productPage.clickBuyButton()
                .getAddedProductFragment()
                .shouldHaveProductTitle(searchItem)
                .closeAddedProductModal();
    }

    @Step("Verify that correct product information is displayed in cart")
    public void verifyProductInfoInBasket(String searchItem, String productPrice) {
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
