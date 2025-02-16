package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//img[@title='Show details for Apple MacBook Pro 13-inch']")).click();
        /* Xpath is an adress of the element
     DOM - Document Object Model
     //*[@id = 'start' or 'stop'] veya için ve için ise and
     //*[contains(@name,'xyz')] içinde "xyz" olan bütün
     //*[starts-with(@name, 'xyz')] "xyz" ile başlayanlar
         */


    }
}
