package Selenium;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
