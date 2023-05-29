import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity6
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.name("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.className("button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\'menu\']//ul//b[text()=\"Directory\"]")).isEnabled();
        driver.findElement(By.xpath("//div[@class=\'menu\']//ul//b[text()=\"Directory\"]")).click();
        String SD = driver.findElement(By.xpath("//h1[text()=\"Search Directory\"]")).getText();
        Assert.assertEquals(SD,"Search Directory");
        System.out.println("Activity 6 pass");

        driver.close();
    }
}
