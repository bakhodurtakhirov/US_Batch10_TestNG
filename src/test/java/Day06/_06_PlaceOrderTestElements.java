package Day06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;

public class _06_PlaceOrderTestElements {
    // We locate our elements for the function we want to test in this class and
    // if we need to use same elements in other tests we can call from this class

    public _06_PlaceOrderTestElements(){

        PageFactory.initElements(DriverClass.driver,this);
        // driver.findElement(By...)
    }

    @FindBy(name = "search")
    public WebElement searchInput;

    @FindBy(css = "i[class=\"fa fa-search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[text()=\"Add to Cart\"])[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[text()=\"Shopping Cart\"]")
    public WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    public WebElement checkOutButton;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(name = "agree")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(xpath = "(//div[@id=\"content\"]//p)[1]")
    public WebElement successMessage;

}
