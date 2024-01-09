package Selenium;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.time.Duration;

public class vwoLoginTest {
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

//driver.manage().timeouts().implicitlyWait(10);
        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("abc.gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("123");

        WebElement button_submit = driver.findElement(By.id("js-login-btn"));
        button_submit.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(error_message.getText());
                Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

    }

    @Owner("Promode")
    @Test
    public void testPositive() throws InterruptedException {
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("contact+atb5x@thetestingacademy.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.clear();
        password.sendKeys("ATBx@1234");

        List<WebElement> button_submit = driver.findElements(By.xpath("//button[contains(@class,\"btn--positive\")]/span[text()=\"Sign in\"]"));
        button_submit.get(0).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement name_on_dashboard_page_ele = driver.findElement(By.xpath("//span[@data-qa=\"lufexuloga\"]"));
        System.out.println(name_on_dashboard_page_ele.getText());

        Assert.assertEquals(name_on_dashboard_page_ele.getText(), "Aman");

    }










    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
