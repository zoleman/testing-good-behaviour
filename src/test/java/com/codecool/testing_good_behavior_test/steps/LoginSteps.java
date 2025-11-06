package com.codecool.testing_good_behavior_test.steps;

import com.codecool.testing_good_behavior.pages.LoginPage;
import com.codecool.testing_good_behavior.pages.MainPage;
import com.codecool.testing_good_behavior_test.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before
    public void setUpScenario() {
        super.setup();
        driver.get("http://localhost:5173/");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDownScenario() {
        if (driver != null) driver.quit();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        mainPage.navigateToLoginScreen();
    }

    @When("I log in with {string} and {string}")
    public void i_log_in_with_and(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should see the logout button")
    public void i_should_see_the_logout_button() {
        assertTrue(mainPage.isLogoutButtonVisible(), "Logout button should be visible after valid login");
    }

    @Then("I should see the invalid login modal")
    public void i_should_see_the_invalid_login_modal() {
        assertTrue(loginPage.isModalVisible(), "Invalid login modal should be visible");
    }
}
