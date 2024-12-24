package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

public class UserLoginTest extends TestBase
{
    HomePage homeobject;

    SoftAssert softassert = new SoftAssert();


    String email = "asdm22350@gmail.com";
    String password = "wanas22";

    @Test(priority = 1)
    public void UserCanLoginSucessfully()
    {
        homeobject=new HomePage(driver);
        homeobject.OpenLoginPage();
        LoginPage loginObject;

        loginObject=new LoginPage(driver);
        loginObject.UserLogin(email,password);

        softassert.assertTrue(homeobject.logoutlink.getText().contains("Log out"));
        System.out.println("Log out");
    }

    @Test(priority = 2)
    public void UserCanLogOut()
    {
        homeobject= new HomePage(driver);
        homeobject.LogOut();
    }

}

