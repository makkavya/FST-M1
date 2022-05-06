package Liveprojects;

/*
6. Logging into the site
Goal: Open the website and log-in using the provided credentials.
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Find the navigation bar.
d. Select the menu item that says “My Account” and click it.
e. Read the page title and verify that you are on the correct page.
f. Find the “Login” button on the page and click it.
g. Find the username field of the login form and enter the username into that field.
h. Find the password field of the login form and enter the password into that field.
i. Find the login button and click it.
j. Verify that you have logged in.
k. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        //open the browser
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
    }
        @Test
        public void LoginTest()
        {
            driver.findElement(By.linkText("My Account")).click();
            System.out.println(driver.getTitle());
            driver.findElement(By.xpath("//div[@id = 'uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91']/div/div[2]/a")).click();
            driver.findElement(By.id("user_login")).sendKeys("root");
            driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
            driver.findElement(By.id("wp-submit")).click();

        }
        @AfterMethod
    public void closebrowser()
        {
            driver.close();
        }

}
