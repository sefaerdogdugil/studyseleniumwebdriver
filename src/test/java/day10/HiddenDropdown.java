package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HiddenDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[7]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
       Thread.sleep(5000);
        // driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[4]")).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']//span"));
        System.out.println("Number of options in dropdown: " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }



    }

}
