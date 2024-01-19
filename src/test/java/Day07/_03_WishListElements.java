package Day07;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;

import java.util.List;

public class _03_WishListElements {

    public _03_WishListElements(){
        PageFactory.initElements(DriverClass.driver,this);
    }

    @FindBy(css = "div[class=\"product-thumb\"]")
    public List<WebElement> productList;

    @FindBy(xpath = "(//i[@class=\"fa fa-heart\"])[1]")
    public WebElement wishList;

    @FindBy(xpath = "(//td[@class=\"text-left\"]//a)[2]")
    public WebElement productNameInWishList;

    @FindBy(css = "a[data-original-title=\"Remove\"]")
    public WebElement removeFromWishListButton;

}
