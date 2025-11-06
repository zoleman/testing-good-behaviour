package com.codecool.testing_good_behavior_test.tests;

import com.codecool.testing_good_behavior.pages.LoginPage;
import com.codecool.testing_good_behavior.pages.MainPage;
import com.codecool.testing_good_behavior_test.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    public void setup() {
        super.setup();
        driver.get("http://localhost:5173/");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        mainPage.navigateToLoginScreen();
    }

    @Test
    void testValidLogin() {
        loginPage.login("asd@asd.com", "asd123");

        assertTrue(mainPage.isLogoutButtonVisible());
    }

    @Test
    void testInvalidLogin() {
        loginPage.login("asd@qwe.com", "asd123");

        assertTrue(loginPage.isModalVisible());
    }

    @Test
    void testInvalidEmailLogin() {
        loginPage.login("qwe", "asd123");

        assertTrue(loginPage.isModalVisible());
    }
}
