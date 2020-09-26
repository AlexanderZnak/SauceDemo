package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Success login")
    @Description("Validation of correct working the login with the valid data")
    public void productsPageShouldBeOpenedAfterLogin() {
        loginSteps
                .login(USERNAME, PASSWORD)
                .validateIsProductsPageOpened();
    }

    @Test(description = "Negative login with empty username")
    @Description("Validation of appearing the errors with using empty username")
    public void emptyLogin() {
        loginSteps
                .login("", PASSWORD)
                .validateErrorMessage("Epic sadface: Username is required");
    }

    @Test(description = "Negative login with empty password")
    @Description("Validation of appearing the errors with using empty password")
    public void emptyPassword() {
        loginSteps
                .login(USERNAME, "")
                .validateErrorMessage("Epic sadface: Password is required");
    }

    @Test(description = "Negative login with invalid data")
    @Description("Validation of appearing the errors with using invalid data")
    public void AuthorizationWithInvalidData() {
        loginSteps
                .login(System.getProperty("bla", "bla"), System.getProperty("bla2", "bla"))
                .validateErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

}
