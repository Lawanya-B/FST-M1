import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity8
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
        driver.findElement(By.xpath("//a/span[contains(text(),'Apply Leave')]")).click();//div[@id="content"]//div[@class="inner"]//div[@id="panel_draggable_0_0"]//a[contains(@href,'applyLeave')]
        WebElement dayOff = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select leave = new Select(dayOff);
        leave.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-05-23"+ Keys.ENTER);
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2023-05-24"+ Keys.ENTER);
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        String pa =driver.findElement(By.xpath("//*[contains(text(),'Pending Approval')]")).getText();
        Assert.assertEquals(pa,"Pending Approval");
        System.out.println("Activity 8 pass");
        
        driver.close();
    }
}
