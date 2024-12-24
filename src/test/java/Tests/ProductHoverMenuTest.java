package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.Objects;


public class ProductHoverMenuTest extends TestBase
{
    HomePage homeObject;

    @Test
    public void UserCanSelectSubcategoryFromMainMenu()
    {
        homeObject = new HomePage(driver);
        homeObject.selectNotebooksMenu();

        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("Notebooks"));
        System.out.println("Notebooks");

    }


}
