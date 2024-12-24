package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase
{
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    String productname ="50's Rockabilly Polka Dot Top JR Plus Size";
    WishListPage wishlistObject;

    @Test(priority = 1)
    public void UserCanSearchProduct() throws InterruptedException
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        Thread.sleep(3000);

        searchObject.productSearch(productname);
        Thread.sleep(3000);

        searchObject.openDetailsPage();

        Assert.assertTrue(detailsObject.productNamebreadcrump.getText().equalsIgnoreCase(productname));

    }

    @Test(priority = 2)
    public void UsercanAddProductToWishlist() throws InterruptedException
    {
        detailsObject.AddProductToWishlist();
        detailsObject.OpenWishlistPage();
        wishlistObject = new WishListPage(driver);
        Assert.assertTrue(wishlistObject.headerwishlist.isDisplayed());
        Thread.sleep(1000);

        Assert.assertTrue(wishlistObject.productcell.getText().contains(productname));
    }

    @Test(priority = 3)
    public void UserCanRemoveProductFromWishlist() throws InterruptedException {
        wishlistObject = new WishListPage(driver);
        wishlistObject.removeproductfromcart();
        Assert.assertTrue(wishlistObject.emptywishlist.getText().contains("empty!"));
        Thread.sleep(1000);

    }




}