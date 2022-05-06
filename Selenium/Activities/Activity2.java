package Activities;

/*Create a Class with a main() method
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://www.training-support.net
Get the title of the page using driver.getTitle() and print out the title
Use findElement() with the following locators to find the "About Us" link:
id()
className()
linkText()
cssSelector()
Print the text in the WebElement using the getText() method.
Close the browser with driver.close() */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args)  {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.id("about-link")).getText());
        System.out.println(driver.findElement(By.className("green")).getText());



        driver.close();
    }
}
