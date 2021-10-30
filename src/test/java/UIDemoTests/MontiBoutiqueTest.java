package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class MontiBoutiqueTest extends UIBaseTest {

    String url = "https://www.montiboutique.com/en";

    @Test
    public void buyMostExpensiveBag() {

        driver.get(url);

    }

    @Test
    public void checkFilteringByBrand() {

        driver.get(url);

    }
}
