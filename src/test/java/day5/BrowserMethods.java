package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // this will opens new browser window
        Thread.sleep(5000);
        driver.close(); // close single browser window where ever the driver is focused
        // driver.quit(); // close all the browser windows


    }
}
