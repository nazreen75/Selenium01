package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class waits {
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
    public void testNegative() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("abc@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("123");

        List<WebElement> button_submit = driver.findElements(By.xpath("//button[contains(@class,\"btn--positive\")]/span[text()=\"Sign in\"]"));
        button_submit.get(0).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(error_message.getText());


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(error_message, "Your email, password, IP address or location did not match"));
        System.out.println("2 " + error_message.getText());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    }
