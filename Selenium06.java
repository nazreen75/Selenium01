package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;


@Test
public class Selenium06 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();


    }
@Test
public void testBrowser() {

            List <WebElement> button_list = driver.findElements(By.tagName("button"));


    for (WebElement button : button_list){
        System.out.println(button.getText());
    }

/*WebElement linktext_start_trail= driver.findElement(By.linkText("Start a free trial"));
    linktext_start_trail.click();*/

    WebElement linktext_start_trail= driver.findElement(By.partialLinkText("Start a free "));
    linktext_start_trail.click();
    // Locator Strategy ( Find a unique element by using below mechanism)
//        // ID -> NAME -> ClassName -> TagName -> Css Selector -> Xpath
//        // Css Selector vs Xpath -> ideal -> css Selector,
//        // But nowdays 4 GB> ram -> xpath / css same. performance almost sam
}



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}

