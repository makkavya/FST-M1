package Liveprojects;
/*
5. Navigate to another page
Goal: Navigate to the “My Account” page on the site.
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Find the navigation bar.
d. Select the menu item that says “My Account” and click it.
e. Read the page title and verify that you are on the correct page.
f. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new FirefoxDriver();

                //open the browser
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
    }
   @Test
    public void Account()
   {
       driver.findElement(By.linkText("My Account")).click();
       System.out.println(driver.getTitle());
   }

   @AfterMethod
    public void closebrowser()
   {
       driver.close();
   }
}
