package Liveprojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/* 1. Verify the website title
Goal: Read the title of the website and verify the text
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Get the title of the website.
d. Make sure it matches “Alchemy LMS – An LMS Application '' exactly.
e. If it matches, close the browser.
*/
public class Activity1 {

        WebDriver driver;

        @BeforeMethod
        public void setup() {

            driver = new FirefoxDriver();
            //Open a browser.
            driver.get("https://alchemy.hguy.co/lms");
        }
        @Test
        public void TittleTest() {
            String Tittle = driver.getTitle();

            Assert.assertEquals(Tittle, "Alchemy LMS – An LMS Application");

        }

        @AfterMethod
                public void teardown()
        {
            driver.close();
        }
}