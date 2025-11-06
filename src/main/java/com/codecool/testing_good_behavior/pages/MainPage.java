package com.codecool.testing_good_behavior.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By logoutButton = By.xpath("//*[@id=\"root\"]/div/nav/ul/li[5]/button");


    public boolean isLogoutButtonVisible() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(logoutButton))).isDisplayed();
    }

    public void navigateToLoginScreen() {
        driver.get("http://localhost:5173/login");
    }
}
