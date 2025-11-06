package com.codecool.testing_good_behavior_test.base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//@Execution(ExecutionMode.SAME_THREAD)
public abstract class BaseTest {
    protected WebDriver driver;
    /*protected static Dotenv dotenv;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        dotenv = Dotenv.load();
    }*/

    @BeforeEach
    public void setup() {
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.get("http://localhost:5173//");
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver = DriverManager.getDriver();

    }

    @AfterEach
    public void teardown() throws InterruptedException {
        /*if (driver != null) {
            driver.quit();
        }*/
        DriverManager.closeDriver();
    }
}
