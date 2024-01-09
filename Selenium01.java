package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium01 {
    public static void main(String[] args) throws InterruptedException{
//if we are useing selenuim<4.6
        //need to set the property for driver
        //System.setProperty("webdriver.chrome.driver","path");
        // selenium 4.10 manager takes care of all the

        //        System.setProperty("webdriver.edge.driver", "path/to/msedgedriver.exe");
//        // Firefox
//        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
//        // Chrome
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
//        // IE
//        System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
//        // Safari
//        System.setProperty("webdriver.safari.driver", "path/to/safaridriver");
//

        ChromeOptions options=new ChromeOptions();

       // options.addArguments("--maximized");
        options.addArguments("--incognito");
        options.addArguments("--window-size=400,400");
        WebDriver driver =new ChromeDriver(options);
        driver.get("https://sdet.live");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        System.out.println(driver.getTitle());
        driver.quit();
    }
}
