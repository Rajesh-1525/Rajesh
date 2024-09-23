package org.example.addtocart;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartTest {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor
    public AddToCartTest(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to add a food item to the cart
    public void addFoodItemToCart() {
        try {
            // Click the Add button
            WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//android.widget.TextView[@resource-id=\"in.swiggy.android:id/quantity_text_1\"])[2]"))); // Replace with actual XPath
            addButton.click();

            // Proceed to the next session
            WebElement addItemButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.Button[@text=\"Add Item | ₹199.05\"]"))); // Replace with actual XPath
            addItemButton.click();

            WebElement viewCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.view.View[@resource-id=\"in.swiggy.android:id/bottom_spacing\"]"))); // Replace with actual XPath
            viewCartButton.click();

            // Optional: wait for some time to observe the cart contents
            try {
                Thread.sleep(5000); // Wait time for observing the cart contents
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Exception in addFoodItemToCart: " + e.getMessage());
        }
    }
}
