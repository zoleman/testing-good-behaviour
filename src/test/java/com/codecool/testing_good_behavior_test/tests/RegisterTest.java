package com.codecool.testing_good_behavior_test.tests;

import com.codecool.testing_good_behavior_test.base.BaseTest;
import com.codecool.testing_good_behavior.pages.RegisterPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.SAME_THREAD)
public class RegisterTest extends BaseTest {

    @Test
    @Order(1)
    public void registerNewUser(){
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegisterPage();
        registerPage.registerNewUser("test123", "test123", "test@test.com");

        assertTrue(registerPage.checkIfURLEquals("/login"));
    }

    @Test
    @Order(2)
    public void registerFailsOnMissingOrInsufficientData(){
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegisterPage();
        registerPage.registerNewUser("test123", "test123", "test");

        assertFalse(registerPage.checkIfURLEquals("http://localhost:5173/login"));
    }

    @Test
    @Order(3)
    public void registerWithExistingEmail(){
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegisterPage();
        registerPage.registerNewUser("test123", "test123", "test@test.com");

        assertTrue(registerPage.modalMessage().contains("Email already exists"));
    }
}
