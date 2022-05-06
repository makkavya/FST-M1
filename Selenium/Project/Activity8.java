package Liveprojects;

/*
Contact the admin
Goal: Navigate to the “Contact Us” page and complete the form.
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Find the navigation bar.
d. Select the menu item that says “Contact” and click it.
e. Find the contact form fields (Full Name, email, etc.)
f. Fill in the information and leave a message.
g. Click submit.
h. Read and print the message displayed after submission.
i. Close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
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
    public void contact()
    {
        String Contact = driver.findElement(By.id("primary-menu")).getText();

        //System.out.println(AllCourse);
        Assert.assertEquals(Contact, "Home\n" + "All Courses\n" + "About\n" + "Contact\n" + "My Account");
        driver.findElement(By.linkText("Contact")).click();
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Kavya");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kavyamakham456@gmail.com");
        driver.findElement(By.xpath("//input[@class='wpforms-field-large']")).sendKeys("LMS");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("LMS Application");
        driver.findElement(By.xpath("//button[@value='wpforms-submit']")).click();
        String Message= driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']/p")).getText();
        System.out.println(Message);

    }

    @AfterMethod
    public void CloseBrowser()
    {
        driver.close();
    }
}
