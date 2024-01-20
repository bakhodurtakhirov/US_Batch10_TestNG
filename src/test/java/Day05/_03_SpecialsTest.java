package Day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.util.List;

public class _03_SpecialsTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Click on Specials
     * Check if all products are on sale and new price is lower than the first price
     * Run this test with 2 different browsers in parallel
     **/

    @Test
    void specialsTest(){
        WebElement specials = driver.findElement(By.linkText("Specials"));
        specials.click();

//        List<WebElement> oldPriceList = driver.findElements(By.className("price-old"));
//        List<WebElement> newPriceList = driver.findElements(By.className("price-new"));
//
//        Assert.assertEquals(newPriceList.size(), oldPriceList.size());

//        for (int i =0; i< oldPriceList.size(); i++){
//
//            double oldPrice = Double.parseDouble(oldPriceList.get(i).getText().replaceAll("[^0-9.]",""));
//            double newPrice = Double.parseDouble(newPriceList.get(i).getText().replaceAll("[^0-9.]",""));
//
//            Assert.assertTrue(oldPrice>newPrice);
//        }


        List<WebElement> productList = driver.findElements(By.className("caption"));

        for (WebElement product: productList){

            //We can locate an element by using its parent element like below

            // WebElement product = driver.findElement(By.className("caption"));
            // product.findElement(By.className("price-old")).

            // Selenium will only search in the sub elements of the parent element
            //Don't use xpath for locating elements by using their parent like this.
            // It always search in the entire HTML code. W cannot limit
            // xpath with this method
            //WebElement oldPrice = product.findElement(By.className("price-old"));
            //WebElement newPrice = product.findElement(By.className("price-new"));

            double oldPrice = Double.parseDouble(product.findElement(By.className("price-old")).getText().replaceAll("[^0-9.]",""));
            double newPrice = Double.parseDouble(product.findElement(By.className("price-new")).getText().replaceAll("[^0-9.]",""));

//            System.out.println("oldPrice.getText() = " + oldPrice.getText());
//            System.out.println("newPrice.getText() = " + newPrice.getText());
            Assert.assertTrue(oldPrice>newPrice);

        }


    }
}
