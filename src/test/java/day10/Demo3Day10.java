package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Demo3Day10 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();
        List<WebElement> options = driver.findElements(By.id("colors"));
        Thread.sleep(5000);
        System.out.println(options.size());
        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }
        driver.findElement(By.xpath("//select[@id='colors']//option[3]")).click();
    }
}
