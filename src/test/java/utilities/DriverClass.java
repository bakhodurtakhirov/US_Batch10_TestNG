package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class DriverClass {

    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass(alwaysRun = true) // Before Class doesn't work with groups. Because we are not running the class.
    // We are running some tests in the class. To make sure it runs all the time we should add alwaysRun=true
    @Parameters("browserName")
    public void createDriver(@Optional("chrome") String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

//        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement advanceButton = driver.findElement(By.id("details-button"));
        advanceButton.click();

        WebElement proceedLink = driver.findElement(By.id("proceed-link"));
        proceedLink.click();

        login();
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        closePreviousDrivers();
    }

    public void login() {
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("knightrider@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("MichaelKnight1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        loginButton.click();
    }

    public void closePreviousDrivers() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Logger logger = LogManager.getLogger();
    @BeforeMethod(alwaysRun = true)
    public void logsBeforeTest(ITestResult testResult){
        //System.out.println("Test has started");
        // all -> trace -> debug -> info -> warn -> error -> fatal each logging level shows logs with that level and above

//        logger.trace("Trace level log");
//        logger.debug("Debug level log");
//        logger.info("Info level log for test start");
//        logger.warn("Warn level log");
//        logger.error("Error level log");
//        logger.fatal("Fatal level log");

        logger.info(testResult.getMethod().getMethodName()+ " test has started");
    }

    @AfterMethod(alwaysRun = true)
    public void logsAfterTest(ITestResult testResult){
        //System.out.println("Test has ended");
//        logger.info("Info level log for test end");
        logger.info(testResult.getMethod().getMethodName()+" has ended with status of "+testResult.getStatus());
    }
}
