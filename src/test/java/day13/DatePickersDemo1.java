package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickersDemo1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // iFrame içine geçiş yap
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame1);

        // Takvim input'unu bul
        WebElement datePicker = driver.findElement(By.id("datepicker"));

        // Tarih bilgileri
        String year = "2025";
        String month = "September";
        String day = "15";

        // Datepicker aç
        datePicker.click();

        while (true) {
            WebElement datePickerYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            WebElement datePickerMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));

            String currentYear = datePickerYear.getText();
            String currentMonth = datePickerMonth.getText();

            // Eğer istenen yıl ve ay bulunduysa, döngüden çık
            if (currentYear.equals(year) && currentMonth.equals(month)) {
                break;
            }

            // Eğer istenen tarih ileri bir tarihse ileri butonuna tıkla, değilse geri butonuna tıkla
            if (Integer.parseInt(currentYear) < Integer.parseInt(year) || currentYear.equals(year)) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            } else {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }
        }

        // Gün seçme işlemi
        List<WebElement> allDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
        for (WebElement dateElement : allDate) {
            if (dateElement.getText().equals(day)) {
                dateElement.click();  // **Günü seç**
                break;
            }
        }

        System.out.println("Seçilen tarih: " + day + " " + month + " " + year);

        // Tarayıcıyı kapat
        driver.quit();
    }
}
