package com.codecool.testing_good_behavior_test.steps;

import com.codecool.testing_good_behavior.pages.RegisterPage;
import com.codecool.testing_good_behavior_test.base.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterSteps {
    private WebDriver driver;
    private RegisterPage registerPage;

    @Given("I am on the registration page")
    public void openRegistrationPage() {
        driver = DriverManager.getDriver(); // You can reuse your BaseTest setup
        registerPage = new RegisterPage(driver);
        registerPage.navigateToRegisterPage();
    }

    @When("I register a new user with valid data")
    public void registerUser() {
        registerPage.registerNewUser("testasdfgh@123", "testasdfgh@123", "test2@test.com");
    }

    @When("I try to register with a faulty email")
    public void registerWithFaultyEmail() {
        registerPage.registerNewUser("testasdfgh@123", "testasdfgh@123", "test2");
    }

    @When("I try to register with an existing email")
    public void registerWithExistingEmail() {
        registerPage.registerNewUser("testasdfgh@123", "testasdfgh@123", "test2@test.com");
    }



    @Then("I should be redirected to the login page")
    public void verifyRedirect() {
        assertTrue(registerPage.checkIfURLEquals("/login"));
    }

    @Then("I should stay on the register page")
    public void verifyMissingEmailError() {
        assertFalse(registerPage.checkIfURLEquals("http://localhost:5173/login"));
    }

    @Then("I should see an error message about duplicate email")
    public void verifyDuplicateEmailError() {
        assertTrue(registerPage.modalMessage().contains("Email already exists"));
    }
}
