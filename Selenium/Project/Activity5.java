import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity5
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
        driver.findElement(By.xpath("//div[@class=\'menu\']//ul//b[text()=\"My Info\"]")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_optGender_1")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("John");
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("cena");
        WebElement nationalityDD = driver.findElement(By.id("personal_cmbNation"));
        Select sc = new Select(nationalityDD);
        sc.selectByVisibleText("Hungarian");
        driver.findElement(By.id("btnSave")).click();
        System.out.println("Activity 5 pass");

        driver.close();
    }
}
