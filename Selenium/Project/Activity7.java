import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity7
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
        driver.findElement(By.id("btnSave")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement qualification = driver.findElement(By.xpath("//ul[@id=\"sidenav\"]//a[text()=\"Qualifications\"]"));
        js.executeScript("arguments[0].scrollIntoView();", qualification);
        driver.findElement(By.xpath("//ul[@id=\"sidenav\"]//a[text()=\"Qualifications\"]")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("John");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Engineer");
        driver.findElement(By.id("experience_from_date")).clear();
        driver.findElement(By.id("experience_from_date")).sendKeys("2023-05-23");
        driver.findElement(By.id("experience_to_date")).clear();
        driver.findElement(By.id("experience_to_date")).sendKeys("2023-05-23");
        driver.findElement(By.id("btnWorkExpSave")).click();
        System.out.println("Activity 7 pass");

        driver.close();
    }
}
