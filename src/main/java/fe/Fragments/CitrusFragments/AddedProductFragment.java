package fe.Fragments.CitrusFragments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AddedProductFragment {

    private final SelenideElement addedProductModal = $(".pr.scrollbar");
    private final SelenideElement closeAddedProductModal = addedProductModal.$(".icon-0-2-31");

    public AddedProductFragment shouldHaveProductTitle(String searchItem) {
        addedProductModal.should(appear);
        addedProductModal.shouldHave(text(searchItem));
        return this;
    }

    public AddedProductFragment closeAddedProductModal() {
        closeAddedProductModal.click();
        addedProductModal.should(disappear);
        return this;
    }
}
