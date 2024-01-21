package Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.time.Duration;
import java.util.List;

public class _01_AddressFunction extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Address Book
     * Add a new address
     * Edit the address
     * Delete the address
     * Write 3 different tests for add, edit and delete address
     */

    @Test(groups = "MyGroup")
    void addAddressTest() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("Michael");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Knight");

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("1234 Independence Ave.");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Las Vegas");

        WebElement postcode = driver.findElement(By.id("input-postcode"));
        postcode.sendKeys("52364");

//        WebElement countrySelect = driver.findElement(By.id("input-country"));
//        Select select = new Select(countrySelect);
//        select.selectByVisibleText("United States");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()=\"Nevada\"]")));
//
//        WebElement stateSelect = driver.findElement(By.id("input-zone"));
//        select  = new Select(stateSelect);
//        select.selectByVisibleText("Nevada");

        WebElement selectCountry = driver.findElement(By.id("input-country"));
        List<WebElement> countryList = selectCountry.findElements(By.tagName("option"));
        List<WebElement> listOfRegions = driver.findElements(By.xpath("//select[@id='input-zone']//option")); // List of regions of The United Kingdom

        Select countrySelect = new Select(selectCountry);
        int randomCountryIndex = (int) (Math.random()*(countryList.size()-1))+1; // To avoid selecting Please Select

        countrySelect.selectByIndex(randomCountryIndex);

        WebElement selectRegion = driver.findElement(By.id("input-zone"));

        Select regionSelect = new Select(selectRegion);

        if (!countrySelect.getOptions().get(randomCountryIndex).getText().equals("United Kingdom")) {   // If selected country is not United Kingdom wait until one of its regions is not visible.
                                                                                                        // If the selected country is UK it will skip if statement and continue with selected one of its regions randomly
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOf(listOfRegions.get(1)));
        }

        List<WebElement> listOfNewRegions = driver.findElements(By.xpath("//select[@id='input-zone']//option")); // List of regions of the new selected country
        int randomRegionIndex = ((int) (Math.random()*(listOfNewRegions.size()-1)))+1;

        regionSelect.selectByIndex(randomRegionIndex);

        WebElement continueButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        continueButton.click();

        WebElement message = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(message.getText().contains("successfully"));
    }

    @Test(dependsOnMethods = "addAddressTest")
    void editAddressTest(){
        WebElement editButton = driver.findElement(By.linkText("Edit"));
        editButton.click();

        WebElement city = driver.findElement(By.id("input-city"));
        city.clear();
        city.sendKeys("New York City");

        WebElement stateSelect = driver.findElement(By.id("input-zone"));
        Select select  = new Select(stateSelect);
        select.selectByVisibleText("New York");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        continueButton.click();

        WebElement message = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(message.getText().contains("successfully"));
    }

    @Test(dependsOnMethods = "addAddressTest", groups = "MyGroup")
    void deleteAddressTest(){
        WebElement deleteButton = driver.findElement(By.xpath("(//a[text()=\"Delete\"])[2]"));
        deleteButton.click();

        WebElement message = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(message.getText().contains("successfully"));
    }

    //TODO: Edit addAddress and and editAddress test to select random country and random state/region

}
