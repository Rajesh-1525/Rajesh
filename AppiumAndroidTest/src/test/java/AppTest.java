import io.appium.java_client.android.AndroidDriver;
import org.example.login.LoginPage;
import org.example.search.SearchPage;
import org.example.addtocart.AddToCartTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    public static void main(String[] args) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Rajesh");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("udid", "A64HJFNVHYJBD67X");
        caps.setCapability("appPackage", "in.swiggy.android");
        caps.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
        caps.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://localhost:4723"), caps);

            // Login page actions
            LoginPage loginPage = new LoginPage(driver);
            loginPage.selectMobileNumberFromPopup();
            loginPage.handleAutoOTPEntry();
            loginPage.handleLocationAccess();
            System.out.println("Login successful.");

            // Wait for app transition
            Thread.sleep(10000); // Wait time for transition after login

            // Search page actions
            SearchPage searchPage = new SearchPage(driver);
            searchPage.searchAndSelectRestaurant();
            System.out.println("Search completed.");

            // Add to cart actions
            AddToCartTest addToCartPage = new AddToCartTest(driver);
            addToCartPage.addFoodItemToCart();
            System.out.println("Add to cart and view cart actions completed.");

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL for Appium server: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
