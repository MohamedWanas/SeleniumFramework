package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import java.time.Duration;

public class TestBase
  {
      public static WebDriver driver;


      @BeforeSuite
      @Parameters({"browser"})
      public void startDriver(@Optional("chrome") String browserName)
      {
          if (browserName.equalsIgnoreCase("chrome"))
          {
              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
          }

          else if (browserName.equalsIgnoreCase("firefox"))
          {
              WebDriverManager.firefoxdriver().setup();
              driver = new FirefoxDriver();
          }

          else if (browserName.equalsIgnoreCase("edge"))
          {
              WebDriverManager.edgedriver().setup();
              driver = new EdgeDriver();
          }

          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          driver.get("https://demowebshop.tricentis.com/");

      }


      @AfterSuite
      public void stopdriver()
      {
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          driver.quit();
      }
      //take screenshot when test case fail and add it in the screenshot folder


      @AfterMethod
      public void screenshootOnFailure(ITestResult result)
      {
          if (result.getStatus()==ITestResult.FAILURE)
          {
              System.out.println("Failed!");
              System.out.println("Taking Screenshoot....");
              Helper.capturescreenshoot(driver, result.getName());
          }
      }

  }
