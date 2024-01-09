package Selenium.waits;

import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tables02hrms {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        // create session  via API and session ID is generated
        driver = new ChromeDriver();
        //
        // launch the browser with the url mention
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testWebTables() throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(5000);

        System.out.println("Employee - " + findEmployeeStatus("Aman"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String findEmployeeStatus(String employeeName) {
        int row = findRowsCount();
        int col = findColsCount();

        String firstPart = "//div[@role='table']/div[2]/div[";
        String secondPart = "]/div/div[";
        String thirdPart = "]";
        String employeeStatus = null;



        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String dynamicPath = firstPart + i + secondPart + j + thirdPart;
                WebElement dataElement = driver.findElement(By.xpath(dynamicPath));
                String data = dataElement.getText();

                if (data.contains(employeeName)) {
                    String employeeStatusPath = dynamicPath + "/following-sibling::div[3]";
                    WebElement statusElement = driver.findElement(By.xpath(employeeStatusPath));
                    employeeStatus = statusElement.getText();

                    System.out.println(employeeName + " employee status is " + employeeStatus);

                    if (employeeStatus.equals("Terminated")) {
                        String editStatusPath = dynamicPath + "//following-sibling::div/div/button[1]";
                        driver.findElement(By.xpath(editStatusPath)).click();
                    }
                    break;
                }
            }
        }
        return employeeStatus;
    }

    private int findRowsCount() {
        return driver.findElements(By.xpath("//div[@role='table']/div[2]/div")).size();
    }

    private int findColsCount() {
        return driver.findElements(By.xpath("//div[@role='table']/div[2]/div[1]/div/div")).size();
    }
}