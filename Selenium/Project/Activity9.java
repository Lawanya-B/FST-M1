import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9
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
        driver.findElement(By.xpath("//div[@class=\'menu\']//ul//b[text()=\"My Info\"]")).click();
        driver.findElement(By.xpath("//ul[@id=\"sidenav\"]//a[text()=\"Emergency Contacts\"]")).click();
        WebElement ecl = driver.findElement(By.xpath("//table[@id=\"emgcontact_list\"]//tbody"));
        System.out.println(ecl.getText());
        System.out.println("Activity 9 pass");

        driver.close();
    }
}
