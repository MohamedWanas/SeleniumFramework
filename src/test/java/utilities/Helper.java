package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper
{
    //method to take screenshot when the test case fail

    public static void capturescreenshoot(WebDriver driver , String screenshootname)
    {
        Path dest = Paths.get("./screenshoots",screenshootname+".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream Out = new FileOutputStream(dest.toString());
            Out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            Out.close();
        }
        catch (IOException e) {
            System.out.println("Excpetion while taking screenshoot" + e.getMessage());

        }
    }

}
