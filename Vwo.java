package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vwo {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys("abc.com");
        driver.findElement(By.id("login-password")).sendKeys("asoon");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(4000);
        driver.close();
    }
}