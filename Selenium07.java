package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium07 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

    }
    @Test
    public void testBrowser() throws InterruptedException {

        // Locator Strategy ( Find a unique element by using below mechanism)
//        // ID -> NAME -> ClassName -> TagName -> Css Selector -> Xpath
//        // Css Selector vs Xpath -> ideal -> css Selector,
//        // But nowdays 4 GB> ram -> xpath / css same. performance almost same.
//WebElement make_appn_btn=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
//a[@id="btn-make-appointment"]
      //  make_appn_btn.click();

        WebElement make_app_btn=driver.findElement(By.xpath("//a[contains (@id,'appointment')]"));
        make_app_btn.click();
        Thread.sleep(3000);




        //input[@value="ThisIsNotAPassword"]
        //input[@name="username"]
        //input[@name="password"]
        //button[@id="btn-login"]
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}



