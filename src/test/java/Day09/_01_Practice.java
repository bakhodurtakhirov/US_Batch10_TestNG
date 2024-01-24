package Day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.util.*;

public class _01_Practice extends DriverClass {

//    Go to https://opencart.abstracta.us/index.php?route=account/login
//    Login
//    Hover over Desktops
//    Click on Show All Desktops
//    Select Sort By Name (A-Z)-> Check if the products are sorted accordingly.
//    Run the test for Sort By Name (Z-A), Price (Low>High), Price (High>Low) as well and
//    check if the products are sorted accordingly.

    @Test(dataProvider = "sortTypes")
    void sortFunctionTest(String sortType) {
        WebElement desktops = driver.findElement(By.linkText("Desktops"));

        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).build().perform();

        WebElement showAllDesktops = driver.findElement(By.linkText("Show All Desktops"));
        showAllDesktops.click();

        WebElement sortDropDown = driver.findElement(By.id("input-sort"));

        Select sortTypeSelect = new Select(sortDropDown);
        sortTypeSelect.selectByVisibleText(sortType);

        if (sortType.equals("Name (A - Z)")) {
            List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class=\"caption\"]//a"));
            List<String> productTitlesString = new ArrayList<>();

            for (WebElement product : productTitles) {
                productTitlesString.add(product.getText().toLowerCase());
            }

            Collections.sort(productTitlesString);

            for (int i = 0; i < productTitles.size(); i++) {
                Assert.assertEquals(productTitlesString.get(i), productTitles.get(i).getText().toLowerCase());
            }
        } else if (sortType.equals("Name (Z - A)")) {
            List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class=\"caption\"]//a")); //Z-A
            List<String> productTitlesString = new ArrayList<>();

            for (WebElement product : productTitles) {
                productTitlesString.add(product.getText().toLowerCase()); // Z-A
            }

            Collections.sort(productTitlesString); // A-Z

            for (int i = 0; i < productTitles.size(); i++) {
                Assert.assertEquals(productTitlesString.get(i), productTitles.get(productTitles.size() - 1 - i).getText().toLowerCase());
                //productTitlesString.get(i) counts like 0,1,2,3,4,5
                // productTitles.get(productTitles.size()-1-i) gives us the last element of the list. counts like 5,4,3,2,1,0
            }
        } else if (sortType.equals("Price (Low > High)")) {

            List<WebElement> priceList = driver.findElements(By.className("price-tax"));

            for (int i = 0; i < priceList.size() - 1; i++) {

                double price1 = Double.parseDouble(priceList.get(i).getText().replaceAll("[^0-9.]", ""));
                double price2 = Double.parseDouble(priceList.get(i + 1).getText().replaceAll("[^0-9.]", ""));

                Assert.assertTrue(price1 <= price2);
            }
        } else if (sortType.equals("Price (High > Low)")) {
            List<WebElement> priceList = driver.findElements(By.className("price-tax"));

            for (int i = 0; i < priceList.size() - 1; i++) {

                double price1 = Double.parseDouble(priceList.get(i).getText().replaceAll("[^0-9.]", ""));
                double price2 = Double.parseDouble(priceList.get(i + 1).getText().replaceAll("[^0-9.]", ""));

                Assert.assertTrue(price1 >= price2);
            }
        }

    }

    @DataProvider
    public Object[][] sortTypes() {
        return new Object[][]{
                {"Name (A - Z)"},
                {"Name (Z - A)"},
                {"Price (Low > High)"},
                {"Price (High > Low)"}
        };
    }

}
