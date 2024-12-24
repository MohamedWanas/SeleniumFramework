package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegisterationPage extends PageBase
{
    public UserRegisterationPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id = "gender-male")
    WebElement gendarbutton;

    @FindBy(id = "FirstName")
    WebElement fnTxBox;

    @FindBy (id = "LastName")
    WebElement lnTxBox;

    @FindBy(id = "Email")
    WebElement emailTxBox;

    @FindBy(id = "Password")
    WebElement passwordTxBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmpasswordTxBox;

    @FindBy(id = "register-button")
    WebElement submitbutton;

    @FindBy(css = "div.result")
    public WebElement succesmessage;



    public void UserRegisteration(String firstname ,String lastname, String email,
                                  String password,String confirmpassword )
    {

        clickbutton(gendarbutton);

        settxtElementtxt(fnTxBox,firstname);

        settxtElementtxt(lnTxBox,lastname);

        settxtElementtxt(emailTxBox,email);

        settxtElementtxt(passwordTxBox,password);

        settxtElementtxt(confirmpasswordTxBox,confirmpassword);

        clickbutton(submitbutton);



    }




}
