package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase
{
    public ChangePasswordPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "OldPassword")
    private WebElement oldpasswordtxtBox;

    @FindBy(id = "NewPassword")
    private WebElement newpasswordtxtBox;

    @FindBy(id = "ConfirmNewPassword")
    private WebElement confirmpasswordtxtBox;

    @FindBy(css ="input.button-1.change-password-button")
    private WebElement submitbuton;

    @FindBy(css = "div.result")
    public WebElement successmessage;

    public void Userchangepassword(String oldpassword , String newpassword , String confirmpassword)
    {
        settxtElementtxt(oldpasswordtxtBox,oldpassword);

        settxtElementtxt(newpasswordtxtBox,newpassword);

        settxtElementtxt(confirmpasswordtxtBox,confirmpassword);

        clickbutton(submitbuton);

    }
}

