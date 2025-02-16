package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class HandleBrowsersWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowsIDs = driver.getWindowHandles();

        /*List<String> windowsList = new ArrayList<>(windowsIDs);
     String parentId = windowsList.get(0);
     String childId = windowsList.get(1);
        System.out.println(driver.getTitle());
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle()); */
        for (String winID : windowsIDs) {
           String title = driver.switchTo().window(winID).getTitle();

            if (title.equals("OrangeHRM")) {
                System.out.println("Window Title: " + driver.getCurrentUrl());
            }
        }



    }
}
