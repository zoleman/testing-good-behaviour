package com.codecool.testing_good_behavior_test.tests;

import com.codecool.testing_good_behavior_test.base.BaseTest;
import com.codecool.testing_good_behavior.pages.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser(){
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegisterPage();
        registerPage.registerNewUser("test123", "test123", "test@test.com");

        assertTrue(registerPage.checkIfURLEquals("http://localhost:5173/login"));
    }

    @Test
    public void registerFailsOnMissingOrInsufficientData(){
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegisterPage();
        registerPage.registerNewUser("test123", "test123", "test");

        assertFalse(registerPage.checkIfURLEquals("http://localhost:5173/login"));
    }

    @Test
    public void registerWithExistingEmail(){
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegisterPage();
        registerPage.registerNewUser("test123", "test123", "test@test.com");

        assertTrue(registerPage.modalMessage().contains("Email already exists"));
    }
}
