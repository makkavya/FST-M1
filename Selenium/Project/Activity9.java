package Liveprojects;

/*
9. Complete a simple lesson
Goal: Navigate to a particular lesson and complete it.
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Find the navigation bar.
d. Select the menu item that says “All Courses” and click it.
e. Select any course and open it.
f. Click on a lesson in the course. Verify the title of the course.
g. Click the Mark Complete button on the page (if available).
h. Close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
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
    public void lesson()
    {
        String AllCourse = driver.findElement(By.id("primary-menu")).getText();

        //System.out.println(AllCourse);
        Assert.assertEquals(AllCourse, "Home\n" + "All Courses\n" + "About\n" + "Contact\n" + "My Account");
        driver.findElement(By.linkText("All Courses")).click();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath("//div[@id = 'uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91']/div/div[2]/a")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.xpath("//div[@id = 'ld-course-list-item-69'] //a[@class='ld-item-name']")).click();
        driver.findElement(By.xpath("//div[@id='ld-expand-83'] //div[@class='ld-item-title']")).click();
        String Tittle = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/h1")).getText();
                System.out.println(Tittle);
        String Message1 = driver.findElement(By.xpath("//div[@class='ld-status ld-status-complete ld-secondary-background']")).getText();
                System.out.println(Message1);

    }

    @AfterMethod
    public void Closebrowser()
    {
        driver.close();
    }
}
