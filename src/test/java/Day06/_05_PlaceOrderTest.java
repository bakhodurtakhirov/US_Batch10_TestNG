package Day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.time.Duration;

public class _05_PlaceOrderTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for ipod
     * Add the first result to cart
     * Click on cart icon
     * Click on Check Out
     * Fill the form
     * Click on Confirm and verify that your order is successful
     **/

    @Test
    void placeOrderTest() {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("ipod");

        WebElement searchButton = driver.findElement(By.cssSelector("i[class=\"fa fa-search\"]"));
        searchButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("(//span[text()=\"Add to Cart\"])[1]"));
        addToCartButton.click();

        WebElement shoppingCart = driver.findElement(By.xpath("//span[text()=\"Shopping Cart\"]"));
        shoppingCart.click();

        WebElement checkOutButton = driver.findElement(By.linkText("Checkout"));
        checkOutButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));

        WebElement continue1 = driver.findElement(By.id("button-payment-address"));
        continue1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));

        WebElement continue2 = driver.findElement(By.id("button-shipping-address"));
        continue2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));

        WebElement continue3 = driver.findElement(By.id("button-shipping-method"));
        continue3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("agree")));

        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();

        WebElement continue4 = driver.findElement(By.id("button-payment-method"));
        continue4.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));

        WebElement confirmOrder = driver.findElement(By.id("button-confirm"));
        confirmOrder.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id=\"content\"]//p)[1]")));

        WebElement successMessage = driver.findElement(By.xpath("(//div[@id=\"content\"]//p)[1]"));
        Assert.assertTrue(successMessage.getText().contains("successfully "));
    }
}
