package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
      {
        public LoginPage(WebDriver driver)

         {
           super(driver);
         }

         @FindBy(id = "Email")
          WebElement emailTxtbox;

        @FindBy(id = "Password")
          WebElement passwordTxtbox;

        @FindBy(css = "input.button-1.login-button")
          WebElement loginbutton;


        public void UserLogin(String email , String password)
        {
            settxtElementtxt(emailTxtbox,email);

            settxtElementtxt(passwordTxtbox,password);

            clickbutton(loginbutton);
        }


      }
