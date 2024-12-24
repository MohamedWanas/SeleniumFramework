package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase
{
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Actions actions;
    //create constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver,this);

    }

    protected static void clickbutton(WebElement button)
    {
        button.click();

    }

    protected static void settxtElementtxt(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }

    public void scrollToButtom()
    {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void ClearTxt(WebElement element)
    {
        element.clear();
    }



}
