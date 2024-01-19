package Day07;

import Day06._06_PlaceOrderTestElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClass;

public class _01_PlaceOrderTestWithPOM extends DriverClass {

    @Test
    void placeOrderTest(){
        _06_PlaceOrderTestElements elements = new _06_PlaceOrderTestElements();

        elements.searchInput.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToCartButton.click();
        elements.shoppingCart.click();
        elements.checkOutButton.click();

        wait.until(ExpectedConditions.visibilityOf(elements.continue1));
        elements.continue1.click();

        wait.until(ExpectedConditions.visibilityOf(elements.continue2));
        elements.continue2.click();

        wait.until(ExpectedConditions.visibilityOf(elements.continue3));
        elements.continue3.click();

        wait.until(ExpectedConditions.visibilityOf(elements.agree));
        elements.agree.click();

        elements.confirm.click();

        wait.until(ExpectedConditions.visibilityOf(elements.successMessage));
        Assert.assertTrue(elements.successMessage.getText().contains("successfully "));
    }
}
