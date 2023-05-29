import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity4
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.name("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.className("button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='menu']//ul//b[text()=\"PIM\"]")).click(); //a[@class='firstLevelMenu']//b[text()='PIM']")
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("SampleTest2");
        driver.findElement(By.id("lastName")).sendKeys("SampleTest2");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.xpath("//b[text()='PIM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@id,'empName')]")).sendKeys("SampleTest2 SampleTest2");
        driver.findElement(By.id("searchBtn")).click();
        String firstName = driver.findElement(By.xpath("//div[@id='tableWrapper']//tbody//td[3]//a")).getText();
        String lastName = driver.findElement(By.xpath("//div[@id='tableWrapper']//tbody//td[4]//a")).getText();
        Assert.assertEquals(firstName,"SampleTest2");
        Assert.assertEquals(lastName,"SampleTest2");
        System.out.println("Activity 4 pass");

        driver.close();
    }
}
