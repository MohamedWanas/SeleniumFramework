package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.Objects;

public class UserCheckoutProductTest extends TestBase
{
    HomePage homeobject;
    UserRegisterationPage registerObject;
    SoftAssert softassert = new SoftAssert();

    String firstname = "mohamed";
    String lastname = "wanas";
    String email = "tiger6@gmail.com";
    String oldpassword = "wanas2233";
    String cofirmpassword = "wanas2233";

    @Test(priority = 1)
    public void UserCanRegisterSucessfully() {

        homeobject = new HomePage(driver);
        homeobject.openRegistriationPage();

        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration(firstname, lastname, email, oldpassword, cofirmpassword);

        softassert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
        System.out.println("Your registration completed");
    }


    String productName = "Fiction";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage cartPage;
    String quantity = "2";

    @Test(priority = 2)
    public void UserCanSearchProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.openDetailsPage();

        Assert.assertTrue(detailsObject.productNamebreadcrump.getText().equalsIgnoreCase(productName));

    }

    @Test(priority = 3)
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
    @Test(priority = 4)
    public void UserCanCheckoutProduct() throws InterruptedException
    {
        checkoutObject = new CheckoutProductPage(driver);
        cartPage.OpenCheckoutpage();
        checkoutObject.UserCheckOutProduct("88","cairo","Elmostqbal",
                "12345","0106485405");

        Assert.assertTrue(checkoutObject.productname.isDisplayed());
        Assert.assertTrue(checkoutObject.productname.getText().contains(productName));
        checkoutObject.confirmOrder();
        Assert.assertTrue(checkoutObject.successmessage.isDisplayed());
        Thread.sleep(1000);
        checkoutObject.ViewOrderDetails();
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("orderdetails"));
        orderObject = new OrderDetailsPageObject(driver);
        orderObject.DownloadPDFInvoice();

    }

    @Test(priority = 5)
    public void RegisterdUserCanLogOut()
    {
        homeobject.LogOut();
    }


}
