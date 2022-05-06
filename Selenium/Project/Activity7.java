package Liveprojects;

/*
Count the number of courses
Goal: Navigate to the “All Courses” page and count the number of courses.
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Find the navigation bar.
d. Select the menu item that says “All Courses” and click it.
e. Find all the courses on the page.
f. Print the number of courses on the page
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7 {
    WebDriver driver;
    WebDriver List;

    @BeforeMethod
    public void setup()
    {
        driver = new FirefoxDriver();
        //open the browser
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
    }
    @Test
    public void AllCourse()
    {
        String AllCourse = driver.findElement(By.id("primary-menu")).getText();

        //System.out.println(AllCourse);
        Assert.assertEquals(AllCourse, "Home\n" + "All Courses\n" + "About\n" + "Contact\n" + "My Account");
        driver.findElement(By.linkText("All Courses")).click();
        //java.util.List<WebElement> Course = driver.findElements(By.xpath("//div[@id='ld-course-list-content-2f03b97ab51efe00449b53a93c07fbeb']"));
        java.util.List<WebElement> Course = driver.findElements(By.id("uagb-section-9c044dbd-a808-4032-85ee-e89f1b44d750"));
        int Count = Course.size();
        System.out.println(Count);
    }
    @AfterMethod
    public void Closebrowser() {
        driver.close();
    }
}
