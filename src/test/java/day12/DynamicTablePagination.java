package day12;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicTablePagination {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Customers')])[2]")).click();
        // Ekrana sığmadığı için zoom ayarı yapmak zorunda kaldım böyle çözebildim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='0.50'");

        Thread.sleep(5000);
        WebElement indexPages = driver.findElement(By.xpath("(//div[@class='col-sm-6 text-end'])[1]"));
        System.out.println(indexPages.getText());
        String pagesText = indexPages.getText();
        int totalPages = Integer.parseInt(pagesText.substring(pagesText.indexOf("(") + 1, pagesText.indexOf("Pages") - 1));

        for (int i = 1; i <= totalPages; i++) {
            Thread.sleep(2000);
            if (i > 1) {
                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + i + "]"));
                active_page.click();
            }

        }
        int noOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
        for (int r = 1; r <= noOfRows; r++) {
            String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]")).getText();
            String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]")).getText();
            System.out.println(customerName + "\t" + email);
        }

    }

}
