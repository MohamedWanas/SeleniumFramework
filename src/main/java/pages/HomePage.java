package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase
{
    public HomePage(WebDriver driver)
    {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerlink;

    @FindBy(linkText = "Log out")
    public WebElement logoutlink;

    @FindBy(linkText = "Log in")
    WebElement loginlink;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement myaccount;

    @FindBy(linkText = "Contact us")
    WebElement contactuslink;

    @FindBy(xpath ="/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")
    WebElement computermenu;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[2]/a")
    WebElement notebookselement;




    public void openRegistriationPage()
    {
        clickbutton(registerlink);
    }

    public void LogOut()
    {
        clickbutton(logoutlink);
    }

    public void OpenLoginPage()
    {
        clickbutton(loginlink);
    }

    public void OpenMyAccount()
    {
        clickbutton(myaccount);
    }

    public void OpenContactUsPage()
    {
        scrollToButtom();
        clickbutton(contactuslink);
    }

    public void selectNotebooksMenu()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        actions.moveToElement(computermenu).moveToElement(notebookselement).click().build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
