package Tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.UserRegisterationPage;


public class UserRegisterationTest extends TestBase
{
    HomePage homeobject;
    UserRegisterationPage registerObject;
    SoftAssert softassert = new SoftAssert();

    String firstname = "mohamed";
    String lastname = "wanas";
    String email = "tiger590@gmail.com";
    String password = "wanas22";
    String cofirmpassword = "wanas22";

    @Test(priority = 1)
    public void UserCanRegisterSucessfully() throws InterruptedException {

        homeobject = new HomePage(driver);
        homeobject.openRegistriationPage();


        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration(firstname, lastname, email, password, cofirmpassword);

        softassert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
        Thread.sleep(2000);
        System.out.println("Your registration completed");

    }

    @Test(priority = 2)
    public void UserCanLogOut()
    {
        homeobject.LogOut();
    }








}







