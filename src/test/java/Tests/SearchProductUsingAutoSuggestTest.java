package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase
{
    String productName = "Fiction";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
    public void UserCanSearchWithAutoSuggest()
    {
        searchObject = new SearchPage(driver);
        searchObject.ProductSearchUsingAutoSuggest("fic");
        detailsObject = new ProductDetailsPage(driver);

        Assert.assertTrue(detailsObject.productNamebreadcrump.getText().equalsIgnoreCase(productName));
        System.out.println(productName);

    }

}

