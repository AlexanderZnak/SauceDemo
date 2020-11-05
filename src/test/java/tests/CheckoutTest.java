package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "Success checkout")
    @Description("Validation of correct working the checkout with the valid data")
    public void validData() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "Znak", "123456")
                .validateIsPageOpened();
    }

    @Test(description = "Negative checkout with empty fields")
    @Description("Validation of appearing the errors with using empty fields")
    public void emptyFields() {
        checkoutSteps
                .fillInCheckoutInfo("", "", "")
                .validateErrorMessage("Error: First Name is required");
    }

    @Test(description = "Negative checkout with spaces fields")
    @Description("Validation of appearing the errors with using spaces fields")
    public void spacesFields() {
        checkoutSteps
                .fillInCheckoutInfo(" ", " ", " ")
                .validateErrorMessage("Error: First Name doesn't have any characters");
    }

    @Test(description = "Negative checkout with integer First name")
    @Description("Validation of appearing the errors with using integer First name")
    public void integerFirstName() {
        checkoutSteps
                .fillInCheckoutInfo("123", "Znak", "12345")
                .validateErrorMessage("Error: First Name doesn't have integers");
    }

    @Test(description = "Negative checkout with integer Last name")
    @Description("Validation of appearing the errors with using integer Last name")
    public void integerLastName() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "123", "12345")
                .validateErrorMessage("Error: Last Name doesn't have integers");
    }

    @Test(description = "Negative checkout with letter Zip code")
    @Description("Validation of appearing the errors with using letter Zip code")
    public void letterZipCode() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "Znak", "blabla")
                .validateErrorMessage("Error: Zip Code doesn't have any letters");
    }

    @Test(description = "Negative checkout with character First name")
    @Description("Validation of appearing the errors with using character First name")
    public void characterFirstName() {
        checkoutSteps
                .fillInCheckoutInfo("!@#", "Znak", "12345")
                .validateErrorMessage("Error: First Name doesn't have any characters");
    }

    @Test(description = "Negative checkout with character Last name")
    @Description("Validation of appearing the errors with using character Last name")
    public void characterLastName() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "!@#", "12345")
                .validateErrorMessage("Error: Last Name doesn't have any characters");
    }

    @Test(description = "Negative checkout with character Zip code")
    @Description("Validation of appearing the errors with using character Zip code")
    public void characterZipCode() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "Znak", "!@#")
                .validateErrorMessage("Error: Zip Code doesn't have any characters");
    }

    @Test(description = "Negative checkout with empty Last name")
    @Description("Validation of appearing the errors with using empty Last name")
    public void emptyLastName() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "", "123456")
                .validateErrorMessage("Error: Last Name is required");
    }

    @Test(description = "Negative checkout with empty Zip code")
    @Description("Validation of appearing the errors with using empty Zip code")
    public void emptyZipCode() {
        checkoutSteps
                .fillInCheckoutInfo("Sasha", "Znak", "")
                .validateErrorMessage("Error: Postal Code is required");
    }

    @Test(description = "Cancel by clicking the button 'Cancel'")
    @Description("Validation of correct working functionality the button 'Cancel'")
    public void cancel() {
        checkoutSteps.cancel();
    }

}
