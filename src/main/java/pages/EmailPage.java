package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase
{
    public EmailPage (WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    private WebElement friendemailTxtBox;

    @FindBy(id = "PersonalMessage")
    private WebElement messageTxtBox;

    @FindBy(name = "send-email")
    private WebElement sendemailButton;

    @FindBy(css = "div.result")
    public WebElement Successmessage;

    public void SendEmailToFriend(String friendemail,String message)
    {
        settxtElementtxt(friendemailTxtBox,friendemail);
        settxtElementtxt(messageTxtBox,message);
        clickbutton(sendemailButton);


    }
}
