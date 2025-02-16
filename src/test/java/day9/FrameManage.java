package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameManage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

       /* driver.switchTo().frame(name)
        driver.switchTo().frame(id)
        driver.switchTo().frame(WebElement)
        driver.switchTo().frame(index)
        */
        //Frame 1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("(//input[@name='mytext1'])[1]")).sendKeys("welcome");

         driver.switchTo().defaultContent();
       //Frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("welcome");
    driver.switchTo().defaultContent();


    WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
    driver.switchTo().frame(frame3);
    driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("welcome");
    // inner iframe -- part of frame3 itself
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();

    }
}
