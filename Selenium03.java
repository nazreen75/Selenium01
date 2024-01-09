package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium03 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://bingo.com");
        driver.navigate().to("https://www.google.com");
        driver.navigate().to(new URL("https://app.vwo.com"));
        driver.navigate().back();
       // driver.navigate().forward();
        driver.navigate().refresh();
        System.out.println(driver.getTitle());


        driver.quit();

    }
}
