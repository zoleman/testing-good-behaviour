package com.codecool.testing_good_behavior_test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.SAME_THREAD)
public abstract class BaseTest {
    protected WebDriver driver;
    protected static Dotenv dotenv;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        dotenv = Dotenv.load();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("http://localhost:5173//");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    @AfterEach
    public void teardown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
            Thread.sleep(1000);
        }
    }
}
