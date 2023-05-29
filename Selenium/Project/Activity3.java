import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity3
{
    public static void main(String[] args)
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.name("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.className("button")).click();
        String homePage = driver.getTitle();
        Assert.assertEquals(homePage,"OrangeHRM");
        System.out.println("Activity 3 pass");

        driver.close();
    }
}
