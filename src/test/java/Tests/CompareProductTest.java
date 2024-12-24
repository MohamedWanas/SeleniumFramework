package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductpage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareProductTest extends TestBase
{
    String productName1 = "Fiction";
    String productName2 ="Blue Jeans";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    CompareProductpage compareObject;
    HomePage homeobject;

    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        homeobject = new HomePage(driver);
        compareObject =new CompareProductpage(driver);
        searchObject.productSearch(productName1);
        searchObject.openDetailsPage();
        Thread.sleep(3000);
        detailsObject.OpenCompareListPage();
        Thread.sleep(3000);
        compareObject.CompareProducts();

        searchObject.productSearch(productName2);
        searchObject.openDetailsPage();
        detailsObject.OpenCompareListPage();
        driver.navigate().to("https://demowebshop.tricentis.com/compareproducts");
        compareObject.CompareProducts();
    }



    @Test(priority = 2)
    public void UserCanClearCompareList() throws InterruptedException {
        compareObject.RemoveProductfromComparePage();
        Assert.assertTrue(compareObject.emptycomparepage.getText().contains("You have no items to compare."));
        Thread.sleep(1000);

    }


}
