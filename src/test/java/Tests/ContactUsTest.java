package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class  ContactUsTest extends TestBase
{
    HomePage home;
    ContactUsPage contactpage;
    String fullname = "asd asd";
    String email = "tiger250@gmail.com";
    String enqyiry = "Mohamed send message";

    @Test
    public void UserCanUseContactUs()
    {
        home = new HomePage(driver);
        home.OpenContactUsPage();
        contactpage = new ContactUsPage(driver);
        contactpage.ContactUs(fullname,email,enqyiry);

        Assert.assertTrue(contactpage.succesmessage.getText().contains
                ("Your enquiry has been successfully sent to the store owner."));
        System.out.println("Your enquiry has been successfully sent to the store owner.");
    }


}
