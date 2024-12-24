package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CheckoutProductPage extends PageBase
{
    public  CheckoutProductPage(WebDriver driver)
    {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
    @FindBy(xpath = "//input[@id='BillingNewAddress_FirstName']")
    WebElement firstnameTxtBox;

    @FindBy(xpath = "//input[@id='BillingNewAddress_LastName']")
    WebElement lastnameTxtBox;

    @FindBy(xpath = "//input[@id='BillingNewAddress_Email']")
    WebElement emailTxtBox;

    @FindBy(xpath = "//input[@id='BillingNewAddress_Company']")
    WebElement companyTxtBox;

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    public WebElement countrylist;

    @FindBy(xpath = "//input[@id='BillingNewAddress_City']")
    WebElement cityTxtBox;

    @FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
    WebElement addressTxtBox;

    @FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
    WebElement postalcodeTxtBox;

    @FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
    WebElement phonenumberTxtBox;

   @FindBy(xpath = "//*[@id='billing-buttons-container']/input")
   WebElement continuebutton1;

    @FindBy(id = "PickUpInStore")
    WebElement pickup;

    @FindBy(xpath = "//*[@id='shipping-buttons-container']/input")
    WebElement continuebutton2;

    @FindBy(xpath = "//*[@id='paymentmethod_1']")
    WebElement selectpaymentmethod;

    @FindBy(xpath = "//*[@id='payment-method-buttons-container']/input")
    WebElement continuebutton3;

    @FindBy(xpath = "//*[@id='payment-info-buttons-container']/input")
    WebElement continuebutton5;

    @FindBy(className = "product-name")
    public WebElement productname;

    @FindBy(xpath = "//*[@id='confirm-order-buttons-container']/input")
     WebElement confirmbutton;

    @FindBy(css = "div.title")
    public WebElement successmessage;

   @FindBy(linkText = "Click here for order details.")
   WebElement orderdetailsLink;



    public void UserCheckOutProduct(String countryname,String cityname,String address,String postalcode,String phonenumber ) throws InterruptedException
    {
        Select select =new Select(countrylist);
        select.selectByValue(countryname);
        settxtElementtxt(cityTxtBox,cityname);
        settxtElementtxt(addressTxtBox,address);
        settxtElementtxt(postalcodeTxtBox,postalcode);
        settxtElementtxt(phonenumberTxtBox,phonenumber);
        clickbutton(continuebutton1);
        clickbutton(pickup);
        clickbutton(continuebutton2);
        Thread.sleep(1000);
        clickbutton(selectpaymentmethod);

        clickbutton(continuebutton3);
        Thread.sleep(1000);
        clickbutton(continuebutton5);
    }

    public void confirmOrder() throws InterruptedException
    {
        Thread.sleep(2000);
        clickbutton(confirmbutton);
    }

    public void ViewOrderDetails()
    {
        clickbutton(orderdetailsLink);
    }


    public void GuestCheckOutProduct(String firstname, String lastname,String email, String company ,String countryname,String cityname,String address,String postalcode,String phonenumber ) throws InterruptedException
    {
        settxtElementtxt(firstnameTxtBox,firstname);
        settxtElementtxt(lastnameTxtBox,lastname);
        settxtElementtxt(emailTxtBox,email);
        settxtElementtxt(companyTxtBox,company);
        Select select =new Select(countrylist);
        select.selectByValue(countryname);
        settxtElementtxt(cityTxtBox,cityname);
        settxtElementtxt(addressTxtBox,address);
        settxtElementtxt(postalcodeTxtBox,postalcode);
        settxtElementtxt(phonenumberTxtBox,phonenumber);
        clickbutton(continuebutton1);
        clickbutton(pickup);
        clickbutton(continuebutton2);
        Thread.sleep(1000);
        clickbutton(selectpaymentmethod);

        clickbutton(continuebutton3);
        Thread.sleep(1000);
        clickbutton(continuebutton5);
    }


}
