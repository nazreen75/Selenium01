package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;


public class checkboxes {
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
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> allcheck= driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        for (WebElement checkbox :allcheck){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

    }
}
