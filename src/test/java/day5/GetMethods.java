package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // get(url) - open a url on the browser
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // getTitle() returns page title
        String title = driver.getTitle();
        System.out.println(title);
        //getCurrentUr1() - retuns URL of the page
        driver.getCurrentUrl();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //getPageSource()- returns source code of the page
        //String pageSource = driver.getPageSource();
        //System.out.println(pageSource);
        //getWindowHandle() - returns ID of the single Browser window
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        //gethindowandles() r returs ID's of the multiple browser windows
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // this will open new browser window
        Set<String> windowids = driver.getWindowHandles();
        System.out.println(windowids);

        driver.close(); // Close one page
        driver.quit(); // Close all page
    }
}
