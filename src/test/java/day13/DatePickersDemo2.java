package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickersDemo2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // İstenen tarih
        String requiredYear = "2015";
        String requiredMonth = "Sep";
        String requiredDay = "15";

        // Tarih seçiciyi aç
        driver.findElement(By.xpath("//input[@id='txtDate']")).click();

        // Ay seçme
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        monthDropdown.click();
        List<WebElement> months = driver.findElements(By.xpath("//select[@aria-label='Select month']//option"));
        for (WebElement monthElement : months) {
            if (monthElement.getText().equals(requiredMonth)) {
                monthElement.click();
                break;
            }
        }

        // Yıl seçme
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        yearDropdown.click();
        List<WebElement> years = driver.findElements(By.xpath("//select[@aria-label='Select year']//option"));
        for (WebElement yearElement : years) {
            if (yearElement.getText().equals(requiredYear)) {
                yearElement.click();
                break;
            }
        }

        // Gün seçme
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dayElement : days) {
            if (dayElement.getText().equals(requiredDay)) {
                dayElement.click();
                System.out.println("Seçilen gün: " + requiredDay + requiredMonth + requiredYear);
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
