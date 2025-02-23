package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DemoDay12 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. https://testautomationpractice.blogspot.com/ go to page
        2. Go to pagination page read data
        3. Select check boxes
        4. Find how many pages are in table
        5. do it for every page

         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        List<WebElement> pages = driver.findElements(By.xpath("//div[@class='main-outer']//li"));
        int totalPages = pages.size();
        System.out.println("Toplam sayfa sayısı = " + totalPages);
        for (int i = 1; i <= totalPages; i++) {
            // Sayfa bağlantılarını tekrar al (DOM değişebilir)
            pages = driver.findElements(By.xpath("//div[@class='main-outer']//li"));

            // İlgili sayfa bağlantısını al ve tıkla
            WebElement currentPage = pages.get(i - 1);
            System.out.println("Şu anki sayfa = " + currentPage.getText());
            currentPage.click();

            // Sayfanın yüklenmesini bekleyelim
            Thread.sleep(2000);

            //  Belirtilen checkbox'ları seç
            for (int j = 8; j <= 12; j++) {
                WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[" + j + "]"));
                if (!checkBox.isSelected()) {
                    checkBox.click();
                    System.out.println("Checkbox " + j + " işaretlendi.");
                } else {
                    System.out.println("Checkbox " + j + " zaten seçili.");
                }
            }
        }


        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']//tr//td"));
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
    }

}






