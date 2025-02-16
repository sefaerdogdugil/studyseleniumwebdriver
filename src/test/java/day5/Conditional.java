package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conditional {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#gender-male")).click();
        WebElement isMale = driver.findElement(By.cssSelector("#gender-male"));
        boolean isMaleSelected = isMale.isSelected();
        // also use like
        // boolean isMale = driver.findElement(By.cssSelector("#gender-male"));
        // System.out.println("Male selected = " + isMale);
        System.out.println("Male selected = " + isMaleSelected);
        //isDisplayed() for check photo, link etc.
//isEnabled() for writable input, button etc.



    }
}
