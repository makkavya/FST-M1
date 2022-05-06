package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1
{

    AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setup() throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceId","420025039b6464c7");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        //Server URL
        URL serverURL = new URL("https://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(serverURL, caps);

    }

    @Test
    public void MultiplicationTest()
    {
        driver.findElementById("bt_05").click();
        //Find and click Multiplication
        driver.findElementByAccessibilityId("Multiplication").click();
        //Find 5
        driver.findElementById("bt_06").click();
        //Click Equal sign
        driver.findElementByAccessibilityId("Equal").click();
        //Get Result
        String resultValue = driver.findElementById("txtCalc_RealTimeResult").getText();
        System.out.println(resultValue);
        //Assertion
        Assert.assertEquals(resultValue,"30");
    }

    /*@Test
    public void add() {
        // Using resource-id
        driver.findElementById("digit_5").click();
        // Using Accessibility ID
        driver.findElementByAccessibilityId("multiply").click();
        // Using XPath
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        // Display Result
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "45");
    } */

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
