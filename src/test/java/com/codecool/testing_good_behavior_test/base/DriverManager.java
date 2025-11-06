package com.codecool.testing_good_behavior_test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            System.out.println("Closing browser...");
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver = null;
            }
        }
    }
}