package fe.Pages.CitrusPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import fe.Fragments.CitrusFragments.AddedProductFragment;
import fe.Fragments.CitrusFragments.BasketFragment;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CitrusProductPage {

    private AddedProductFragment addedProductFragment = new AddedProductFragment();
    private BasketFragment basketFragment = new BasketFragment();

    private SelenideElement productDetails = $("div[class^=right]");
    private SelenideElement productPrice = productDetails.$("[data-price]");
    private SelenideElement buyButton = productDetails.$("[class*='buyButton'] ");


    public CitrusProductPage shouldHaveProductTitle(String searchItem) {
        productDetails.shouldHave(text(searchItem));
        return this;
    }

    public CitrusProductPage shouldHaveProductPrice(String expectedProductPrice) {
        productPrice.shouldHave(exactText(expectedProductPrice));
        return this;
    }

    public CitrusProductPage clickBuyButton() {
        $(byText("Купить")).shouldBe(visible).click();
        return this;
    }

    public AddedProductFragment getAddedProductFragment() {
        return addedProductFragment;
    }

    public BasketFragment getBasketFragment() {
        return basketFragment;
    }


}
