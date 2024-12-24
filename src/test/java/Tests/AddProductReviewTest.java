package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class AddProductReviewTest extends TestBase
{
    HomePage homeobject;
    UserRegisterationPage registerObject;
    SoftAssert softassert = new SoftAssert();

    String firstname = "asd";
    String lastname = "asd";
    String email = "reportsmm887@gmail.com";
    String password = "asdasd22";
    String cofirmpassword = "asdasd22";

    @Test(priority = 1)
    public void UserCanRegisterSucessfully()
    {
        homeobject = new HomePage(driver);
        homeobject.openRegistriationPage();
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration(firstname, lastname, email, password, cofirmpassword);

        softassert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
    }



    String productName = "Fiction";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    @Test(priority = 2)
    public void UserCanSearchProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.openDetailsPage();

        Assert.assertTrue(detailsObject.productNamebreadcrump.getText().equalsIgnoreCase(productName));
        System.out.println(productName);

    }



    String reviewtitle ="good product";
    String reviewtext ="Hello this book is very good !";
    ProductReviewPage reviewObject;
    @Test(priority = 3)
    public void UserSendemailtofriend() {
        detailsObject.openreviewpage();
        reviewObject = new ProductReviewPage(driver);
        reviewObject.reviewproduct(reviewtitle, reviewtext);

        Assert.assertTrue(reviewObject.succesmessage.getText().contains("Product review is successfully added."));
        System.out.println("Product review is successfully added.");

    }

        @Test(priority = 4)
        public void RegisterdUserCanLogOut()
        {
            homeobject.LogOut();
        }



}
