package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase
{
    public ShoppingCartPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "td.remove-from-cart")
    WebElement removefromcart;

    @FindBy(name = "updatecart")
    WebElement updatecartbutton;

    @FindBy(css = "input.qty-input")
    public WebElement quantitytxt;

    @FindBy(css = "td.subtotal")
    public WebElement subtotal;

    @FindBy(css = "a.product-name")
    public WebElement productname;

    @FindBy(id = "checkout")
    WebElement checkoutbutton;

    @FindBy(id = "termsofservice")
    WebElement agreecheckbox;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")
    WebElement checkoutasguestbutton;

    public void RemoveProdutFromCart()
    {
        clickbutton(removefromcart);
        clickbutton(updatecartbutton);
    }

    public void UpdateProductQuantityinCart(String quantity)
    {
        ClearTxt(quantitytxt);
        settxtElementtxt(quantitytxt,quantity);
        clickbutton(updatecartbutton);
    }

    public void OpenCheckoutpage()
    {
        clickbutton(agreecheckbox);
        clickbutton(checkoutbutton);
    }

    public void OpenGusetPage()
    {
        clickbutton(checkoutasguestbutton);
    }


}
