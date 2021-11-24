package fe.Pages.CitrusPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class CitrusProductListingPage {

    //private ElementsCollection products = $$("[class*=productCardCategory]");

    private ElementsCollection products() {
        return $$("[class*=productCardCategory]");
    }

    private SelenideElement product(String searchItem) {
        return products().find(text(searchItem));
    }

    public CitrusProductListingPage shouldHaveProductTitle(String searchItem) {
        product(searchItem).should(exist);
        return this;
    }

    public String getProductPrice(String searchItem) {
        return product(searchItem).$("[data-price]").text().replace("₴", " ₴");
    }

    public CitrusProductPage clickProduct(String searchItem) {
        product(searchItem).click();
        return new CitrusProductPage();
    }
}
