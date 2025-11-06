package com.codecool.testing_good_behavior.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    @FindBy(xpath = "//*[@id=\"root\"]/div/form/label[1]/input")
//    private WebElement emailField;
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/form/label[2]/input")
//    private WebElement passwordField;
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/form/button")
//    private WebElement loginButton;

    private final By emailField = By.xpath("//*[@id=\"root\"]/div/form/label[1]/input");
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/form/label[2]/input");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/form/button");
    private final By invalidLoginModalOkButton = By.xpath("//*[@id=\"root\"]/div/div/div/button");
    private final By loginForm = By.xpath("//form");

    public void login(String email, String password) {
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm)));
        removeHtml5ValidationFromForm(loginForm);
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))).sendKeys(email);
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))).sendKeys(password);
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton))).click();
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

    public boolean isModalVisible() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginModalOkButton))).isDisplayed();
    }
}
