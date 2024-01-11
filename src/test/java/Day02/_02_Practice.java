package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverClass;

public class _02_Practice extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Edit Account
     * Update name
     * Click on Continue
     * Verify the success message
     * Then change it back to the old name
     */
    @Test
    void updateAccountTest(){
        updateAccount("George");
        updateAccount("Michael");
    }

    void updateAccount(String name){

        WebElement editAccount = driver.findElement(By.linkText("Edit Account"));
        editAccount.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.clear();
        firstname.sendKeys(name);

        WebElement continueButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        continueButton.click();

        WebElement message = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(message.getText().contains("successfully"));
    }
}
