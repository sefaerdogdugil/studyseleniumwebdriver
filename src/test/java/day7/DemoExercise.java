package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DemoExercise {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Turkish");
        driver.findElement(By.cssSelector("//input[@type='submit']")).click();
        List<WebElement> results = driver.findElements(By.className("form-group"));
        System.out.println("Sonuç sayısı: " + results.size());

        for (int i = 0; i < results.size(); i++) {
            List<WebElement> updatedResults = driver.findElements(By.className("form-group"));
            updatedResults.get(i).click();
        }
        Set<String> windowHandles = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();
        // Yeni açılan pencerelere geç ve başlığını yazdır
        for (String winID : windowHandles) {
            if (!winID.equals(mainWindow)) {
                driver.switchTo().window(winID);
                System.out.println("Sayfa başlığı: " + driver.getTitle());

            }
        }
        driver.switchTo().window(mainWindow);
        driver.close();
        driver.quit();
}
}
