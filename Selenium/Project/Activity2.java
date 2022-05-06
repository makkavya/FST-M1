package Liveprojects;
/*
Goal: Read the heading of the website and verify the text
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Get the heading of the webpage.
d. Make sure it matches “Learn from Industry Experts” exactly.
e. If it matches, close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new FirefoxDriver();
        //Open a browser.
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void HeadingTest() {
        String Heading =
                driver.findElement(By.className("uagb-ifb-title")).getText();

        Assert.assertEquals(Heading, "Learn from Industry Experts");

    }

    @AfterMethod
    public void Closebrowser() {
        driver.close();
    }
}
