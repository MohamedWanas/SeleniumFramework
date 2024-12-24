package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToshoppingCartTest extends TestBase
{
    String productName = "Fiction";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage cartPage;
    String quantity = "2";

    @Test(priority = 1)
    public void UserCanSearchProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.openDetailsPage();

        Assert.assertTrue(detailsObject.productNamebreadcrump.getText().equalsIgnoreCase(productName));

    }

    @Test(priority = 2)
    public void UserCanAddProductToCart() throws InterruptedException
    {
         detailsObject = new ProductDetailsPage(driver);
         detailsObject.AddproductToCart();
         cartPage = new ShoppingCartPage(driver);

        Thread.sleep(1000);
        driver.navigate().to("https://demowebshop.tricentis.com/" + "/cart");
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.productname.getText().contains("Fiction"));
        cartPage.UpdateProductQuantityinCart(quantity);
        Assert.assertTrue(cartPage.subtotal.getText().contains("48.00"));
        Thread.sleep(1000);

    }


    @Test(priority = 4)
    public void UserCanRemoveProductFromCart()
    {
        cartPage = new ShoppingCartPage(driver);
        cartPage.RemoveProdutFromCart();
    }

}
