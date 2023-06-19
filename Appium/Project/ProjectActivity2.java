package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity2 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
    }

    //Google Keep
    @Test
    public void googleKeep()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Google Tasks");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        // Assertion
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title")));
        String title = driver.findElement(AppiumBy.id("index_note_title")).getText();
        Assert.assertEquals(title, "Google Tasks");
        String note = driver.findElement(AppiumBy.id("index_note_text_description")).getText();
        Assert.assertEquals(note, "Complete Activity with Google Tasks");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}
