package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{
    public ContactUsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "FullName")
   private WebElement fullnameTxtBox;

    @FindBy(id = "Email")
   private WebElement emailTxtBox;

    @FindBy(id = "Enquiry")
   private WebElement enquiryTxtBox;

    @FindBy(name = "send-email")
   private WebElement submitbutton;

    @FindBy(css = "div.result")
    public WebElement succesmessage;

    public void ContactUs(String fullname , String email ,String enquiry)
    {
        settxtElementtxt(fullnameTxtBox,fullname);
        settxtElementtxt(emailTxtBox,email);
        settxtElementtxt(enquiryTxtBox,enquiry);
        clickbutton(submitbutton);
    }
}
