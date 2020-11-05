package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(description = "Go to the link 'All Items' from the burger menu")
    @Description("Validation of correct working the link 'All Items'")
    public void allItems() {
        menuSteps
                .goToLink("All Items")
                .validateIsProductsPageOpened();
    }

    @Test(description = "Go to the link 'About' from the burger menu")
    @Description("Validation of correct working the link 'About'")
    public void about() {
        menuSteps
                .goToLink("About")
                .validateUrlIsOpened("https://saucelabs.com/");
    }

    @Test(description = "Go to logout by the link 'Logout' from the burger menu")
    @Description("Validation of correct working logout by the link 'Logout'")
    public void logout() {
        menuSteps
                .goToLink("Logout")
                .validateIsLoginPageOpened();
    }

    @Test(description = "Resetting added products by the link 'Reset App State'")
    @Description("Validation of resetting added products by the link 'Reset App State'")
    public void resetAppStateForCart() {
        menuSteps
                .resetAddedProductsByLink("Reset App State")
                .validateProductIsIntoCart("Sauce Labs Bike Light");
    }

    @Test(description = "Resetting sorted products by the link 'Reset App State'")
    @Description("Validation of resetting sorted products by the link 'Reset App State'")
    public void resetAppStateForSort() {
        menuSteps
                .resetSortedProductByLink("Reset App State")
                .validateSortShouldBeGetDefault();
    }

}
