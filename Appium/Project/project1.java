package liveproject;
/*
Goal: Use the Google Tasks app to create a list of activities that need to be completed.
Open the Google Tasks app.
Click the button to add a new task.
Add the following tasks:
Complete Activity with Google Tasks
Complete Activity with Google Keep
Complete the second Activity Google Keep
After each task is added, the Save button should be clicked.
Write an assertion to ensure all three tasks have been added to the list.

 */

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.interceptors.InterceptorOfAListOfElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class project1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceId", "420025039b6464c7");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(serverURL, caps);
    }

    @Test
    public void GoogleTask() {
        driver.findElementByAccessibilityId("Create new task").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title"))).sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();
        driver.findElementByAccessibilityId("Create new task").click();
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();
        driver.findElementByAccessibilityId("Create new task").click();
        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
