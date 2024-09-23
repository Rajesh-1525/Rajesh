package org.example.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Perform the search for the restaurant and select the specific restaurant from the list
    public void searchAndSelectRestaurant() {
        try {
            // Click on the search icon
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement searchIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.ImageView[@resource-id='in.swiggy.android:id/search_icon_iv']")));
            searchIcon.click();
            System.out.println("Search icon clicked.");

            // Debug: Print the page source to check if the search field is present
            System.out.println("Page Source: " + driver.getPageSource());

            // Wait for the search field to become available
            WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.EditText[@content-desc=\"You can Search, Order, Enjoy, Repeat!\"]")));

            // If searchField is null or not displayed, print a warning and check for alternatives
            if (searchField == null || !searchField.isDisplayed()) {
                System.out.println("Search field not displayed, checking for alternative locators.");
                // Use a different XPath or locator strategy if necessary
            }

            // Enter the restaurant name 'KFC'
            searchField.sendKeys("KFC");
            System.out.println("Restaurant name 'KFC' entered.");

            // Add a short delay to ensure the list is loaded
            Thread.sleep(3000); // Wait for the restaurant list to load

            // Select 'KFC' from the search results
            WebElement restaurantOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.TextView[@resource-id='in.swiggy.android:id/title' and @text='KFC']")));
            restaurantOption.click();
            System.out.println("Selected 'KFC' from the list.");

            // Add a short delay for the second page load
            Thread.sleep(3000);

            // Select 'KFC' again from the second list
            WebElement secondRestaurantOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.TextView[@resource-id='in.swiggy.android:id/list_item_title' and @text='KFC']")));
            secondRestaurantOption.click();
            System.out.println("Selected 'KFC' again from the second list.");

        } catch (Exception e) {
            System.out.println("Exception occurred during restaurant search and selection: " + e.getMessage());
        }
    }
}
