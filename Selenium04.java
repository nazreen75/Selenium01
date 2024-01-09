package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium04 {
    public static void main(String[] args) throws InterruptedException {
        // flow to automate
        // navigate to  url
        //find the first element username and enter the email id
        // find the second element password and enter the password
        // find the third element and click / submit
        // verify that  error should come

        // create session  via API and session ID is generated
        WebDriver driver= new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://app.vwo.com");

        // page load strategy - Normal ,which load al the resources , we will wait
        // for all the resources to load

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.manage().window().maximize();

        WebElement username= driver.findElement(By.id("login-username"));
        username.sendKeys("abc.gmail.com");

        WebElement password= driver.findElement(By.id("login-password"));
        password.sendKeys("123");

        WebElement button_submit= driver.findElement(By.id("js-login-btn"));
        button_submit.click();

        Thread.sleep(3000);
        WebElement error_message= driver.findElement(By.id( "js-notification-box-msg"));
        System.out.println(error_message.getText());





    }
}
