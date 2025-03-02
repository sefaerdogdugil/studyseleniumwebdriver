package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Day14Demo1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        field1.clear();
        field1.sendKeys("Selenium");

        WebElement buttonDouble = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement field = driver.findElement(By.xpath("//div[@id='droppable']"));

        act.doubleClick(buttonDouble).perform();
        Thread.sleep(2000);
        act.dragAndDrop(element, field).perform();


    }
}
