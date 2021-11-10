package UIDemoPages.Pages.RozetkaPageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaPageFactoryMainPage {

    WebDriver driver;

    @FindBy(xpath="//input[@name='search']")
    private WebElement searchField;

    @FindBy(css=".button.button_color_green")
    private WebElement searchButton;

    public RozetkaPageFactoryMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaPageFactoryProductsPage performSearch(String searchText) {
        enterTextIntoSearchField(searchText);
        clickSearchButton();
        return new RozetkaPageFactoryProductsPage(driver);
    }

    private void enterTextIntoSearchField(String searchText) {
        searchField.sendKeys(searchText);
    }

    private void clickSearchButton() {
        searchButton.click();
    }
}


