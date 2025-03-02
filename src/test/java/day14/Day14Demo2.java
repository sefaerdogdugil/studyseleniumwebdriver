package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Day14Demo2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Actions act = new Actions(driver);

        WebElement price = driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
        WebElement bank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
        WebElement amountDebit = driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
        WebElement account = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
        WebElement accountCredit = driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
        WebElement sales = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
        WebElement price2 = driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
        WebElement amountCredit = driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));

        act.dragAndDrop(price, amountDebit).perform();
        Thread.sleep(2000);
        act.dragAndDrop(bank, account).perform();
        Thread.sleep(2000);
        act.dragAndDrop(sales, accountCredit).perform();
        Thread.sleep(2000);
        act.dragAndDrop(price2, amountCredit).perform();


    }
}
