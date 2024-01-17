package Day05;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.util.List;

public class _02_SearchFunctionTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for "mac" (send the keyword as a parameter from the xml file)
     * Check if all results contains mac key word
     */

    @Test
    @Parameters("searchKeyWord")
    void searchFunctionTest(String keyword){
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.cssSelector("i[class=\"fa fa-search\"]"));
        searchButton.click();

        List<WebElement> resultList = driver.findElements(By.cssSelector("div[class=\"caption\"]>h4"));

        for (WebElement result: resultList){
            Assert.assertTrue(result.getText().toLowerCase().contains(keyword.toLowerCase()));
        }

    }














}
