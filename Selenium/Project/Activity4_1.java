package Liveprojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Verify the title of the second most popular course
Goal: Read the title of the second most popular course on the website and verify the
text
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Get the title of the second most popular course.
d. Make sure it matches “Email Marketing Strategies” exactly.
e. If it matches, close the browser.
 */
public class Activity4_1
{
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new FirefoxDriver();
        //Open a browser.
        driver.get("https://alchemy.hguy.co/lms");
    }
   @Test
    public void SecondTittle()
   {
    String SecondTittle = driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3")).getText();
            System.out.println(SecondTittle);
       Assert.assertEquals(SecondTittle,"Email Marketing Strategies");
   }
    @AfterMethod
    public void Closebrowser()
    {
        driver.close();
    }
}
