package day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;


public class NavigationalCommands {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        WebDriver driver = new ChromeDriver();

        /*URL myUrl = new URL("https://demo.nopcommerce.com/");
        driver.navigate().to(myUrl);  Olso use for open an url */
        driver.navigate().to("https://demo.nopcommerce.com/"); //   driver.get() = accepts only String format
        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();

    }
}
