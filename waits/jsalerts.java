package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jsalerts {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention


    }
    @Owner("Nazreen")
    @Test
    public void testBrowser() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // WebElement element= driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]"));
        // WebElement element= driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]"));
        WebElement element= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        element.click();

        Alert alert=driver.switchTo().alert();
        /*String alertText=alert.getText();
        System.out.println(alertText);

      alert.dismiss();
      alert.accept();*/
      alert.sendKeys("hello");
      alert.accept();

      String result=driver.findElement(By.id("result")).getText();
        System.out.println(result);



    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
