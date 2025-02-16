package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.teknosa.com/");
        driver.manage().window().maximize();
        /* tag#id
           tag.classname
           tag[attribute="value"]
           tag.classname[attribute="value"]
         */
        String cssSelectorForHost1 = "efilli-layout-dynamic";
        SearchContext shadow = driver.findElement(By.cssSelector("efilli-layout-dynamic")).getShadowRoot();
        shadow.findElement(By.cssSelector("#b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e")).click();
        //Shadow dom için kullanım
    }
}
