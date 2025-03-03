package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        WebElement textField = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        textField.sendKeys("test ediyorum");
        Actions act = new Actions(driver);
        //CTRL A
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        //CTRL C
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        //Tab
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        Thread.sleep(2000);
        // CTRL V
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();



    }
}
