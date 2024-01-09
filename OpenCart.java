package Selenium;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class OpenCart {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.manage().window().maximize();

    }
    @Owner("test")
    @Test
    public void registration(){
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));

        username.sendKeys("Nazreen");
       WebElement firstname=driver.findElement(By.xpath("//input[@id=\"input-firstname\"]"));
       firstname.sendKeys("Nazreen");
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
