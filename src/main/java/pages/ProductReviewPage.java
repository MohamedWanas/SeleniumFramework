package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase
{
    public ProductReviewPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewtitleBox;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTextBox;

    @FindBy(id = "addproductrating_4")
    WebElement addrate;

    @FindBy(name = "add-review")
    WebElement submitbutton;

    @FindBy(css = "div.result")
   public WebElement succesmessage;

    public void reviewproduct(String reviewtitle , String reviewtext)
    {
        settxtElementtxt(reviewtitleBox,reviewtitle);
        settxtElementtxt(reviewTextBox,reviewtext);
        clickbutton(addrate);
        clickbutton(submitbutton);
    }



}
