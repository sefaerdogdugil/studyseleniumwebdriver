package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locators {
    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.cookies", 2);
        prefs.put("profile.default_content_setting_values.popups", 2);
        options.setExperimentalOption("prefs", prefs);


        WebDriver driver = new ChromeDriver(options);


        driver.get("https://www.demoblaze.com/index.html");
// 1. Case total number of links
        List<WebElement> allLinks = driver.findElements(By.className("nav-link"));
        System.out.println(allLinks.size());
// 2. Case total number of images
        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        System.out.println(allImages.size());
// 3. Case Click with linktext and partLinkText
        driver.findElement(By.linkText("Log in")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();



    }

}
