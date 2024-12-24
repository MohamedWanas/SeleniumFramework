package Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class ChangePasswordTest extends TestBase
{
    HomePage homeobject;

    HomePage accountObject;
    MyAccountPage passwordObject;
    ChangePasswordPage changeObject;
    UserRegisterationPage registerObject;
    SoftAssert softassert = new SoftAssert();

    String firstname = "asd";
    String lastname = "asd";
    String email = "tiger798@gmail.com";
    String oldpassword = "asdasd22";
    String cofirmpassword = "asdasd22";

    @Test(priority = 1)
    public void UserCanRegisterSucessfully() {

        homeobject = new HomePage(driver);
        homeobject.openRegistriationPage();


        registerObject = new UserRegisterationPage(driver);

        registerObject.UserRegisteration(firstname, lastname, email, oldpassword, cofirmpassword);
        softassert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
        System.out.println("Your registration completed");
    }


    String newpassword = "mohamed2256";
    String confirmpassword = "mohamed2256";

    @Test(dependsOnMethods = "UserCanRegisterSucessfully")
    public void ChangePasswordSucessfully()
    {
        accountObject = new HomePage(driver);
        accountObject.OpenMyAccount();

        passwordObject = new MyAccountPage(driver);
        passwordObject.OpenChangepasswordPage();

        changeObject = new ChangePasswordPage(driver);
        changeObject.Userchangepassword(oldpassword,newpassword,confirmpassword);

        softassert.assertTrue(changeObject.successmessage.getText().contains("Password was changed"));
        System.out.println("Password was changed");


    }

    @Test(dependsOnMethods = "UserCanRegisterSucessfully")
    public void RegisterdUserCanLogOut()
    {
        homeobject.LogOut();
    }


    @Test(dependsOnMethods = "RegisterdUserCanLogOut")
    public void UserCanLoginSucessfully()
    {
        homeobject=new HomePage(driver);
        homeobject.OpenLoginPage();
        LoginPage loginObject;
        loginObject=new LoginPage(driver);
        loginObject.UserLogin(email,newpassword);

        softassert.assertTrue(homeobject.logoutlink.getText().contains("Log out"));
        System.out.println("Log out");
    }

    @Test(dependsOnMethods = "UserCanLoginSucessfully")
    public void UserCanLogOut()
    {
        homeobject.LogOut();
    }




}
