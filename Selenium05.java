
package Selenium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium05 {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        // create session  via API and session ID is generated
         driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://app.vwo.com");


    }

    @Test
    public void negativeTC() {
        // flow to automate
        // navigate to  url
        //find the first element username and enter the email id
        // find the second element password and enter the password
        // find the third element and click / submit
        // verify that  error should come


        // page load strategy - Normal ,which load al the resources , we will wait
        // for all the resources to load

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.manage().window().maximize();

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

        Assert.assertEquals("Your email, password, IP address or location did not match", error_message.getText());

    }
@AfterTest
public void closeBrowser(){
    driver.quit();
    }
}


