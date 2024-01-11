package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.DriverClass;

import java.io.IOException;

public class _01_Practice extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Click on My Account
     * Click on Register
     * Fill in the form with valid informations
     * Accept the agreement
     * Click on Continue button
     * Verify that you are signed up
     */

    @Test
    void signUpTest() {

        WebElement myAccountMenu = driver.findElement(By.xpath("//span[text()=\"My Account\"]"));
        myAccountMenu.click();

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("Michael");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Knight");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("knightrider@gmail.com");

        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys("5462158965");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("MichaelKnight1234");

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("MichaelKnight1234");

        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();

        WebElement cont = driver.findElement(By.cssSelector("input[value=\"Continue\"]"));
        cont.click();

        WebElement message = driver.findElement(By.xpath("//p[contains(text(),\"successfully created!\")]"));

        Assert.assertTrue(message.getText().contains("successfully"),"Test is failed");
    }
}
