package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Fluent wait declaration
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
/*
Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
   withTimeout(Duration.ofSeconds(30L))
   .pollingEvery(Duration.ofSeconds(5L))
   .ignoring(NosuchElementException.class);

  WebElement foo = wait.until(new Function<WebDriver, WebElements>(){
   public WebElement apply(WebDriver driver) {
    return driver.findElement(By.id("foo"));
 */