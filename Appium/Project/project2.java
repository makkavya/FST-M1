package liveproject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class project2 {

        AndroidDriver<MobileElement> driver;
        WebDriverWait wait;

        @BeforeMethod
        public void setup() throws MalformedURLException {
            // Set the Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceId", "420025039b6464c7");
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.google.android.keep");
            caps.setCapability("appActivity", ".activities.BrowseActivity");
            caps.setCapability("noReset", true);

            // Instantiate Appium Driver
            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<>(appServer, caps);
            wait = new WebDriverWait(driver, 20);
        }
        @Test
        public void googlekeep()
        {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
            driver.findElement(MobileBy.id("new_note_button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("editable_title")));
            driver.findElementById("editable_title").sendKeys("Workbook");
            driver.findElement(MobileBy.id("edit_note_text")).sendKeys("training was useful");
            driver.findElementByAccessibilityId("Open navigation drawer").click();
            Assert.assertTrue(true,"workbook note is created");
        }
        @AfterMethod
       public void teardown()
        {
            driver.quit();
        }
}