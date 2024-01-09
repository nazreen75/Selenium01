package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class copy {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

    }
    @Owner("Nazreen")
    @Test
    public void testBrowser() throws InterruptedException {
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}

