package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{
    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
    public WebElement productNamebreadcrump;


    @FindBy(css = "input.button-2.email-a-friend-button")
    WebElement emailfriendButton;


    @FindBy(linkText = "Add your review")
    WebElement addreviewbutton;

    @FindBy(id = "add-to-wishlist-button-5")
    WebElement addtowishlistbutton;

    @FindBy(linkText = "wishlist")
    WebElement wishlistpagelink;

    @FindBy(className = "compare-products")
    WebElement addproducttocomparelist;

    @FindBy(id = "add-to-cart-button-45")
    WebElement addtocartbutton;

    @FindBy(linkText = "shopping cart")
    WebElement shoppingcart;



    public void Opensendemail()
    {
        clickbutton(emailfriendButton);
    }


    public void openreviewpage()
    {
        clickbutton(addreviewbutton);
    }

    public void AddProductToWishlist()
    {
        clickbutton(addtowishlistbutton);
    }

    public void OpenWishlistPage()
    {
        clickbutton(wishlistpagelink);
    }

    public void OpenCompareListPage()
    {
        clickbutton(addproducttocomparelist);
    }

    public void AddproductToCart()
    {
        clickbutton(addtocartbutton);
    }

    public void OpenShoppingCartPage()
    {
        clickbutton(shoppingcart);
    }





}
