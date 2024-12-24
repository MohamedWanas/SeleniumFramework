package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase
{
    public SearchPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchtxtBox;

    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchbutton;

    @FindBy(id = "ui-id-2")
    List<WebElement> productlist;

    @FindBy(css = "h2.product-title")
    WebElement producttitle;


    public void productSearch(String productName)
    {
        settxtElementtxt(searchtxtBox,productName);
        clickbutton(searchbutton);
    }


    public void openDetailsPage()
    {
        clickbutton(producttitle);
    }


    public void ProductSearchUsingAutoSuggest(String searchTxt)
    {
        settxtElementtxt(searchtxtBox,searchTxt);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productlist.getFirst().click();
    }
}
