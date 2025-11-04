package com.codecool.testing_good_behavior_test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By registerForm = By.xpath("//form");
    private final By usernameField = By.xpath("//input[@type='text']");
    private final By emailField = By.xpath("//input[@type='email']");
    private final By passwordField = By.xpath("//label[normalize-space(text())='Password:']/input");
    private final By confirmPasswordField = By.xpath("//label[normalize-space(text())='Confirm Password:']/input\n");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By cancelButton = By.xpath("//button[text()='Cancel']");
    private final By errorModal = By.xpath("//div[@class='modal']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToRegisterPage(){
        driver.get("http://localhost:5173/registration");
    }

    public void removeHtml5ValidationFromForm(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].setAttribute('novalidate','true');", element);
        } catch (TimeoutException e) {
            System.out.println("Form not found within timeout: " + locator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfURLEquals(String url){
        try{
            wait.until(ExpectedConditions.urlToBe(url));
            return true;
        }
        catch(TimeoutException e){
            return false;
        }
    }

    public void registerNewUser(String username, String password, String email){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(registerForm));
        removeHtml5ValidationFromForm(registerForm);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }

    public String modalMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorModal)).getText().trim();
    }
}
