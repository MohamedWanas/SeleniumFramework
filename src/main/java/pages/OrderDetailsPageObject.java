package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPageObject extends PageBase
{
    public OrderDetailsPageObject(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(linkText = "PDF Invoice")
    WebElement downloadpdfinvoicebutton;


    public void DownloadPDFInvoice()
    {
        clickbutton(downloadpdfinvoicebutton);
    }


}
