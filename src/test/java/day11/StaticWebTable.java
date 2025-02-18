package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticWebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        List<WebElement> options = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        System.out.println(options.size());
       // read all data
        for (WebElement option : options) {
            System.out.println(option.getText()+"\t");

        }
        Thread.sleep(5000);
        //find total columns in a table
        int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();

        /* int columns = driver.findElements(By.tagName("th")).size();
        u can use tag name, but you have only single table in page */
        System.out.println("Columns size " + columns);
        // read data from specific row and columns (5th row and first column)
        WebElement fiveRowFirstColumn = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]"));
        System.out.println(fiveRowFirstColumn.getText());

        // print book names whose author is Mukesh
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        for (int r = 2; r < rows; r++) {
           String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if (authorName.equals("Mukesh")){
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(bookName + "\t" + authorName);
            }

        }

    }

}
