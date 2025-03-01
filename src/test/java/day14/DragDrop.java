package day14;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragDrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(oslo, norway).perform();
    }
}
