package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestingAcademy {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        WebDriver driver=new ChromeDriver();
        driver.get("https://courses.thetestingacademy.com/login");
        driver.findElement(By.id("email")).sendKeys("abc.com");
        driver.findElement(By.id("login-password")).sendKeys("abc.com");

        driver.quit();




    }
}
