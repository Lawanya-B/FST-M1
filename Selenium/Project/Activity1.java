import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class Activity1
{
    public static void main(String[] args)
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");

        String pageTitle = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Assert.assertEquals(pageTitle,"OrangeHRM");
        System.out.println("Activity 1 pass");

        driver.close();
    }
}
