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
import java.util.NoSuchElementException;

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

        // Get max price Java8 and then click on it
        List<WebElement> productInfo = driver.findElements(By.className("data"));
        System.out.println(productInfo.get(0).findElement(By.cssSelector(".price span"))
                .getAttribute("data-gtm-price"));

        double maxPrice2 = productInfo.stream()
                .map(e -> e.findElement(By.cssSelector(".price span")).getAttribute("data-gtm-price"))
                .mapToDouble(Double::valueOf)
                .max().orElseThrow(() -> new NoSuchElementException("It appears we don't have a value... That's weird...."));

        System.out.println(maxPrice2);

        productInfo.stream()
                .filter(e -> e.findElement(By.cssSelector(".price span"))
                        .getAttribute("data-gtm-price").contains(String.valueOf(maxPrice2)))
                .findFirst().ifPresentOrElse(WebElement::click,
                        () -> {throw new NoSuchElementException("No element with maxPrice was found");});

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

        //another way to check designer
        long numOfBrandOccurrences = designerTitles.stream()
                .filter(e -> e.getText().equalsIgnoreCase(designer))
                .count();
        Assert.assertEquals(numOfBrandOccurrences, designerTitles.size());
    }
}
