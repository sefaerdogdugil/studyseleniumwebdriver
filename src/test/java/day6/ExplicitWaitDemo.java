package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement username = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");
        WebElement password = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        password.sendKeys("admin123");
        WebElement loginButton = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
    }
}