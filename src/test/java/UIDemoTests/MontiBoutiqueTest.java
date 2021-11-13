package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MontiBoutiqueTest extends UIBaseTest {

    String url = "https://www.montiboutique.com/en";

    @Test
    public void buyMostExpensiveBag() {

        driver.get(url);

        WebElement womenClothesMenuItem = driver.findElement(By.cssSelector("[data-menu='#women-desktop']"));
        womenClothesMenuItem.click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".menu [href$=bags]"))));
        WebElement bagsSubMenuItem = driver.findElement(By.cssSelector(".menu [href$=bags]"));
        bagsSubMenuItem.click();

        String expectedTitle = "Women's Bags";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        List<WebElement> prices = driver.findElements(By.cssSelector(".products span[data-gtm-price]"));

        List<Double> convertedPrices = new ArrayList<>();

        for(WebElement price : prices) {
            double convertedPrice = Double.parseDouble(price.getAttribute("data-gtm-price"));
            convertedPrices.add(convertedPrice);
            System.out.println(convertedPrice);
        }

        System.out.println("Size of list:" + convertedPrices.size());

        convertedPrices.sort(Collections.reverseOrder());
        double maxPrice = convertedPrices.get(0);
        System.out.println("Max price is: " + maxPrice);

    }

    /*@DataProvider
    public Object[][] designerNamesDataProvider() {
        return new Object[][] {
                {"alexander mcqueen "},
                {"alexander wang"},
                {"balenciaga"}
        };
    }*/


    @Test
    public void checkFilteringByBrand() {

        driver.get(url);

        WebElement womenClothesMenuItem = driver.findElement(By.cssSelector("[data-menu='#women-desktop']"));
        womenClothesMenuItem.click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".menu [href$=bags]"))));
        WebElement bagsSubMenuItem = driver.findElement(By.cssSelector(".menu [href$=bags]"));
        bagsSubMenuItem.click();

        String expectedTitle = "Women's Bags";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        String designer = "balenciaga";
        WebElement designerFilterOption = driver.findElement(By.xpath("//div[@class='filters no-mobile']//label[text()='" + designer +"']"));
        designerFilterOption.click();

        List<WebElement> designerTitles = driver.findElements(By.cssSelector(".products span.brand"));

        SoftAssert softAssert = new SoftAssert();

        for (WebElement designerTitle : designerTitles) {
            softAssert.assertEquals(designerTitle.getText().toLowerCase(), designer);
        }
        softAssert.assertAll();
    }
}
