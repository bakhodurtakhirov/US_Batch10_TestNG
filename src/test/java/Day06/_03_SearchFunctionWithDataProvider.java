package Day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.util.List;

public class _03_SearchFunctionWithDataProvider extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for mac, samsung, ipod by using data provider
     * Check all results contains these keywords
     * Run the same test with chrome and edge
     */

    @Test(dataProvider = "dataMethod")
    void searchFunctionTest(String keyword){
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.cssSelector("i[class=\"fa fa-search\"]"));
        searchButton.click();

        List<WebElement> resultList = driver.findElements(By.cssSelector("div[class=\"caption\"]>h4"));

        for (WebElement result: resultList){
            Assert.assertTrue(result.getText().toLowerCase().contains(keyword.toLowerCase()));
        }
    }

    @DataProvider
    public Object[][] dataMethod(){
        Object[][] keywordList = {
                {"mac"},
                {"samsung"},
                {"ipod"}
        };

        return keywordList;
    }
}
