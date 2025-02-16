package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class SelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country']"));
        Select drpCountry = new Select(drpCountryEle);
        /*
        selectByVisibleText()
        selectByvalue()
        selectByIndex()
        */
        drpCountry.selectByVisibleText("Japan");
        // capture the options from dropdown
       List<WebElement> options = drpCountry.getOptions();
       System.out.println("Number of options in dropdown : " + options.size());
       //printing the options
        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }

    }
}
