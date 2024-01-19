package Day07;

import Day06._06_PlaceOrderTestElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DriverClass;

public class _02_WishListTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for ipod (send "ipod" from xml file)
     * add one of the elements to the wish list randomly
     * Click on Wish List button
     * Check if the name of the element is the same with the name of the element you added.
     * Use POM
     * Perform non-parallel cross browser test
     */

    @Test
    @Parameters("keyword")
    void wishListTest(@Optional("ipod") String keyword){
        _06_PlaceOrderTestElements plo = new _06_PlaceOrderTestElements();
        _03_WishListElements wish = new _03_WishListElements();

        plo.searchInput.sendKeys(keyword);
        plo.searchButton.click();

        int randomIndex = (int) (Math.random()*wish.productList.size());
//         Creates an index between 0 to size of our products

//         WebElement product = wish.productList.get(randomIndex);  Parent product

//        WebElement productTitle = product.findElement(By.cssSelector("div[class=\"caption\"]>h4"));// Title of parent product
//        String productTitleStr = productTitle.getText();

        String productTitle = wish.productList.get(randomIndex).findElement(By.cssSelector("div[class=\"caption\"]>h4")).getText();
        System.out.println(productTitle);

//        WebElement addToWishListButton = product.findElement(By.cssSelector("button[data-original-title=\"Add to Wish List\"]"));  Wish list button of parent product
//        addToWishListButton.click();
        wish.productList.get(randomIndex).findElement(By.cssSelector("button[data-original-title=\"Add to Wish List\"]")).click();

        wish.wishList.click();

        wait.until(ExpectedConditions.visibilityOf(wish.productNameInWishList));

        Assert.assertEquals(wish.productNameInWishList.getText(), productTitle);

        wish.removeFromWishListButton.click();
    }
}
