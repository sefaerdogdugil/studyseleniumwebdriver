package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        //select spesific check box
        // driver.findElement(By.xpath("//input[@id='sunday']")).click();
        //select all checkboxes
        // for (int i = 0; i < checkBoxes.size(); i++){
        //List<WebElement> updateCheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        //updateCheckBoxes.get(i).click(); }
        //for (WebElement checkBox : checkBoxes) {
        //    checkBox.click();}
        //select last 3 checkboxes formula = 7 - 3 = 4 (starting index) all boxes - want to select = starting index
        for (int i = 4; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
        }
        //for(int = 0; i<checkBoxes.size();i++){
            //if(checkboxes.get(i).isSelected()) { for selected become unselected
            //    checkboxes.get(i).click();

            }
}
