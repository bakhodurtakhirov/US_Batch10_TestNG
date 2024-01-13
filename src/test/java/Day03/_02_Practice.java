package Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class _02_Practice extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Validate that you see all menu options
     */
    @Test(groups = "MyGroup")
    void validateMenuTest(){
        List<WebElement> menuOptions = driver.findElements(By.cssSelector("ul[class=\"nav navbar-nav\"]>li"));

        for (WebElement webElement: menuOptions){
            Assert.assertTrue(webElement.isDisplayed());
        }

        List<String> menuTextList = new ArrayList<>(List.of("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players"));

        for (WebElement webElement: menuOptions){
            Assert.assertTrue(menuTextList.contains(webElement.getText()));
        }
    }
}
