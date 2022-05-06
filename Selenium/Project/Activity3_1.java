package Liveprojects;
/*
Verify the title of the first info box
Goal: Read the title of the first info box on the website and verify the text
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/lms’.
c. Get the title of the first info box.
d. Make sure it matches “Actionable Training” exactly.
e. If it matches, close the browser.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3_1 {

    WebDriver driver;
    @BeforeMethod
    public void setup()
    {

        driver = new FirefoxDriver();
        //Open a browser.
            driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
    }
    @Test
    public void Firstbox()
    {
        String firstinfo = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810\"]/div/div/div/div[2]/h3")).getText();
        System.out.println(firstinfo);
        Assert.assertEquals(firstinfo, "Actionable Training");

    }
    @AfterMethod
    public void Closebrowser()
    {
        driver.close();
    }
}
