package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*  TEST CASES
 1) Launch browser
 2) Open URL https://demo.opencart.com/
 3) Validate title should be
 4) close browser
*/
public class FirstTestCase {
    public static void main(String[] args) {
        // 1) Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2) Open URL https://demo.opencart.com/
        driver.get("https://demo.opencart.com/");

        //3) Validate title should be
        String acual_title = driver.getTitle();
        assert acual_title != null;
        if (acual_title.equals("Your Store")) {

            System.out.println("Test Passed");
        } else
            System.out.println("Test Failed");


        //4) close browser
        driver.quit();


    }
}
