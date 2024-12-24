package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class EmailFriendTest extends TestBase
{
    HomePage homeobject;
    UserRegisterationPage registerObject;

    SoftAssert softassert = new SoftAssert();

    String firstname = "asd";
    String lastname = "asd";
    String email = "Tiger15456@gmail.com";
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

    String friendemail="asd22@gamil.com";
    String message="Hello my friend this book is good for you!";
    EmailPage emailObject;

    @Test(priority = 3)
    public void UserSendemailtofriend()
    {
        detailsObject.Opensendemail();
        emailObject= new EmailPage(driver);
        emailObject.SendEmailToFriend(friendemail , message);

       Assert.assertTrue(emailObject.Successmessage.getText().contains("Your message has been sent."));
    }

    @Test(priority = 4)
    public void RegisterdUserCanLogOut()
    {
        homeobject.LogOut();
    }




}
