package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Slider {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();


        WebElement minSlider = driver.findElement(By.xpath("(//span)[1]"));
        System.out.println("Before slide min = " + minSlider.getLocation());
        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.dragAndDropBy(minSlider, 140, 249).perform();
        System.out.println("After slide min = " + minSlider.getLocation());

        WebElement maxSlider = driver.findElement(By.xpath("(//span)[2]"));
        System.out.println("Before slide max = " + maxSlider.getLocation());
        Thread.sleep(1000);
        act.dragAndDropBy(maxSlider, -100, 249).perform();
        System.out.println("After slide max = " + maxSlider.getLocation());
    }
}
