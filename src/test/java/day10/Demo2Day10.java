package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Demo2Day10 {
    public static void main(String[] args) throws InterruptedException {
        /* 2) Hidden dropdown
        Login to OrangeHRM--> pim--> employee status
        */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")).click();
        Thread.sleep(5000);
        List<WebElement> options = driver.findElements(By.className("//div[@role='option']"));
        System.out.println("Size " +options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }
}
