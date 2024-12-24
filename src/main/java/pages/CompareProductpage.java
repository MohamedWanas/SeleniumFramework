package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProductpage extends PageBase
{
    public CompareProductpage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(linkText = "Clear list")
    WebElement clearlist;

    @FindBy(tagName = "td")
    public List<WebElement> productNameCells;

    @FindBy(tagName = "td")
    public List<WebElement> productPriceCells;


    @FindBy(className = "page-body")
    public WebElement emptycomparepage;

    public void RemoveProductfromComparePage() {
        clickbutton(clearlist);
    }

    public void CompareProducts() {
        for (int i = 1; i < productNameCells.size(); i++) {
            String productName = productNameCells.get(i).getText().trim();
            String productPrice = productPriceCells.get(i).getText().trim();

            System.out.println("Product [" + i + "]" + " : " + productName + " | Price: " + productPrice);
        }


    }

}