package org.example.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Handle pop-up and select the mobile number
    public void selectMobileNumberFromPopup() {
        try {
            // Updated to use Duration.ofSeconds for WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement mobileNumberOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gms:id/phone_number\"]")));
            mobileNumberOption.click();  // Click on the mobile number option in the pop-up
            System.out.println("Mobile number selected from pop-up.");

        } catch (Exception e) {
            System.out.println("Mobile number in pop-up not found. Exception: " + e.getMessage());
        }
    }

    // Click the "Get OTP" button after entering the mobile number


    // Handle the automatic OTP entry
    public void handleAutoOTPEntry() {
        try {
            // Adding a delay for OTP retrieval
            Thread.sleep(10000); // Increased wait time to ensure OTP is retrieved and automatically filled

            System.out.println("OTP should be auto-filled.");

        } catch (Exception e) {
            System.out.println("OTP auto-fill handling failed. Exception: " + e.getMessage());
        }
    }

    // Handle location access (if necessary)
    public void handleLocationAccess() {
        try {
            // Updated to use Duration.ofSeconds for WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement WhileUsingTheAppButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")));
            WhileUsingTheAppButton.click();  // Click the 'Allow' button for location access
            System.out.println("Location access allowed.");

        } catch (Exception e) {
            System.out.println("Location access prompt not found. Exception: " + e.getMessage());
        }
    }
}
