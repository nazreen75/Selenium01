package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.List;

public class tables01 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

    }
    @Owner("Nazreen")
    @Test
    public void testBrowser() throws InterruptedException{
        WebElement table=driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));
        List<WebElement> row_table=table.findElements(By.tagName("tr"));
        System.out.println(row_table.size());
        for(int i=0; i<row_table.size(); i++){
            List<WebElement> col_table = row_table.get(i).findElements(By.tagName("td"));
            for(WebElement element: col_table){
                System.out.println(element.getText());
            }
        }





    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
