package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DoubleClick {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // örnek sayfa bulamadım
        // act.doubleClick(element).perform() olarak kullanılır



    }
}
