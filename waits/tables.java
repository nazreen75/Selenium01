package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class tables {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

}
    @Owner("Nazreen")
    @Test
    public void testBrowser() throws InterruptedException {
        // How to Fetch To Table?
        // Xpath -> //table[@id="customers"], CSS Selector, ID
        // If something is Dynamic In nature - //table[contains@id,"cust"]
        // ByTageName - table - 1 table only

        // Row , Col
        // Number of Rows and Column in table

        int rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        System.out.println(rows);
        System.out.println(col);
        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part="]/td[";
        String third_part="]";

        for(int i=2;i<=rows;i++){
            for(int j=1;j<=col;j++){
                String dynamic_path = first_part+i+second_part+j+third_part;
                //System.out.println(dynamic_path);
                String data=driver.findElement(By.xpath(dynamic_path)).getText();
                //System.out.println(data);
                if(data.contains("Google")){
                    String temp=dynamic_path+"/following-sibling::td[2]";
                    String country_google=driver.findElement(By.xpath(temp)).getText();
                    System.out.println(country_google);
                }
                if(data.contains("Helen Bennett")){
                    String temp1=dynamic_path+"/following-sibling::td";
                    String country=driver.findElement(By.xpath(temp1)).getText();
                    System.out.println(country);

                }

            }
        }


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}



