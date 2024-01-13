package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DriverClass;

public class _03_ContactUsTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * login
     * click on Contact Us
     * send a message
     * check if the url has "success" key word
     * and run your test from XML file
     **/

    @Test
    @Parameters("message") // This one must be the same with xml file
    void contactUsTest(@Optional("We are Batch 10.") String msg) { // optional means if the method is getting parameter from xml use that parameter
        // otherwise use the message in the @Optional annotation
        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement messageInput = driver.findElement(By.id("input-enquiry"));
        messageInput.sendKeys(msg);

        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }
}
