import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DemoDay10 {
    public static void main(String[] args) throws InterruptedException {

           /*Assignment
        1) Handle country dropdown with/without using Select class:
        https://phppot.com/deo/jquery-dependent-dropdown-list-countries-and-states/
        a) count total number of options
        b) print all the options
        c) select one option
        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phppot.com/jquery/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//p[3]//a[1]")).click();
        Thread.sleep(5000);
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='country-list']//option"));
        System.out.println("Country size " + options.size());
        for (WebElement country : options) {
            System.out.println(country.getText());
        }
        driver.findElement(By.id("country-list")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("option[value='2']")).click();


    }
}
