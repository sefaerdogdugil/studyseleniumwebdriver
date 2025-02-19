package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day11Demo {
    public static void main(String[] args) {
        /* Assignment
       1.  https://blazedemo.com/ go to page
       2. Select departure city
       3. Select destination city
       4. Click find flights
       5. Find the lowest price in the table and click on the button
       6. Fill all data
       7. Click on the purchase flight
       8. Check success massage

         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1. go to page
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
        // 2. Select departure city
        driver.findElement(By.xpath("//select[@name='fromPort']")).click();
        driver.findElement(By.xpath("//select[@name='fromPort']//option[3]")).click();
        // 3. Select destination city
        driver.findElement(By.xpath("//select[@name='toPort']")).click();
        driver.findElement(By.xpath("//select[@name='toPort']//option[2]")).click();
        // 4. Click find flights
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        // 5. Find lower price
        List<WebElement> table = driver.findElements(By.xpath("//table[@class='table']//td"));
        for (WebElement tableRow : table) {
            System.out.println(tableRow.getText());
        }
        List<String> tableList = new ArrayList<>();
        for (WebElement tableRow : table) {
            tableList.add(tableRow.getText());
        }
        Collections.sort(tableList);
        System.out.println(tableList);
        driver.findElement(By.xpath("//tbody/tr[3]/td[1]/input[1]")).click();
        // 6. Fill all data
        driver.findElement(By.id("inputName")).sendKeys("Sefa");
        driver.findElement(By.id("address")).sendKeys("Bornova");
        driver.findElement(By.id("city")).sendKeys("Izmir");
        driver.findElement(By.id("state")).sendKeys("Turkey");
        driver.findElement(By.id("zipCode")).sendKeys("35000");
        driver.findElement(By.xpath("//select[@class='form-inline']//option")).click();
        driver.findElement(By.xpath("//select[@class='form-inline']//option[3]")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("123125123123");
        driver.findElement(By.id("creditCardMonth")).sendKeys("5");
        driver.findElement(By.id("creditCardYear")).sendKeys("2031");
        driver.findElement(By.id("nameOnCard")).sendKeys("Sefa Erdogdugil");
        driver.findElement(By.xpath("//label[normalize-space()='Remember me']")).click();
        // 7 . Click purchase flight
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        //8. Check success
        String success = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
        if (success.equals("Thank you for your purchase today!")) {
            System.out.println("Purchase Successful");

        } else
            System.out.println("Purchase Failed");
        driver.quit();

    }
}
