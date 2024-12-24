package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase
{
   public WishListPage(WebDriver driver)
   {
       super(driver);
   }

   @FindBy(css = "h1")
   public WebElement headerwishlist;

   @FindBy(linkText = "50's Rockabilly Polka Dot Top JR Plus Size")
   public WebElement productcell;

   @FindBy(name = "removefromcart")
    public WebElement removefromwishlist;

   @FindBy(name = "updatecart")
    WebElement updatecart;

   @FindBy(className = "wishlist-content")
  public   WebElement emptywishlist;

   public void removeproductfromcart()
   {
       clickbutton(removefromwishlist);
       clickbutton(updatecart);


   }

}
