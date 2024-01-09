package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import java.util.function.Function;

public class waits01 {
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


    @Test
    public void postiveTestCase() {
        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("nazreenshaik75@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.clear();
        password.sendKeys("H@seenabn");

        List<WebElement> button_submit = driver.findElements(By.xpath("//button[contains(@class,\"btn--positive\")]/span[text()=\"Sign in\"]"));
        button_submit.get(0).click();

        //WebElement userName=driver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));

// wait untill the element is visible
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@data-qa='lufexuloga']"),"nazreen shaik"));



        WebElement userName=driver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));
        System.out.println("2 "+userName.getText());

// fluent wait is wait untill polling period
// Automation in the 32 GB, 16gb, 8gb -> polling -> resource allocation
        // 4 GB 2 GB -> Fluent Wait - Save
        // Ex w - IS EASY :), Jr also are able to understand

        // Fluent Wait
        // Condition but with the Polling period


        // 5 %
        /*FluentWait<ChromeDriver> wait1 = new FluentWait<ChromeDriver>
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait1.until(new Function<ChromeDriver, WebElement>() {
            @Override
            public WebElement apply(ChromeDriver edgeDriver) {
                return driver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));
            }
        });*/

        Assert.assertEquals(userName.getText(), "nazreen shaik");


    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}

