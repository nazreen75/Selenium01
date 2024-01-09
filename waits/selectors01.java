package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class selectors01 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

    }
    @Owner("Nazreen")
    @Test
    public void testBrowser() throws InterruptedException {
        WebElement element= driver.findElement(By.id("dropdown"));
        Select select =new Select(element);
        select.selectByVisibleText("Option 2");
    }





}

