package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Objects;

public class CheckoutProductAsGuestTest extends TestBase
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
        detailsObject.OpenShoppingCartPage();
        cartPage = new ShoppingCartPage(driver);

        Thread.sleep(1000);
        Assert.assertTrue(cartPage.productname.getText().contains("Fiction"));
        cartPage.UpdateProductQuantityinCart(quantity);
        Assert.assertTrue(cartPage.subtotal.getText().contains("48.00"));
        Thread.sleep(1000);

    }

    CheckoutProductPage checkoutObject;
    OrderDetailsPageObject orderObject;
    @Test(priority = 3)
    public void GuestCanCheckoutProduct() throws InterruptedException
    {
        checkoutObject = new CheckoutProductPage(driver);
        cartPage.OpenCheckoutpage();
        cartPage.OpenGusetPage();
        checkoutObject.GuestCheckOutProduct("mohamed","wanas","asd5620@gmail.com","koto","25","cairo",
                "Elmostqbal","24687","0123654875");

        Assert.assertTrue(checkoutObject.productname.isDisplayed());
        Assert.assertTrue(checkoutObject.productname.getText().contains(productName));
        checkoutObject.confirmOrder();
        Assert.assertTrue(checkoutObject.successmessage.isDisplayed());
        Thread.sleep(1000);
        checkoutObject.ViewOrderDetails();
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("orderdetails"));
        orderObject = new OrderDetailsPageObject(driver);
        Thread.sleep(2000);
        orderObject.DownloadPDFInvoice();
        Thread.sleep(2000);



    }

}


