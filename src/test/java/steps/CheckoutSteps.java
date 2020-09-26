package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.OverviewPage;

import static org.testng.Assert.assertEquals;

public class CheckoutSteps {
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;

    public CheckoutSteps(WebDriver driver) {
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
    }

    @Step("Validate is overview page opened")
    public CheckoutSteps validateIsPageOpened() {
        overviewPage.isPageOpened();
        return this;
    }

    @Step("Inserting data: '{firstName}', '{lastName}', '{zipCode}' from the checkout page")
    public CheckoutSteps fillInCheckoutInfo(String firstName, String lastName, String zipCode) {
        checkoutPage
                .openPage()
                .insertData(firstName, lastName, zipCode);
        return this;
    }

    @Step("Check the '{expectedErrorMessage}' is displayed")
    public CheckoutSteps validateErrorMessage(String expectedErrorMessage) {
        assertEquals(checkoutPage.getErrorMessage(), expectedErrorMessage);
        return this;
    }

    @Step("Click the cancel from the checkout page and check the cart page is opened")
    public CheckoutSteps cancel() {
        checkoutPage
                .openPage()
                .cancel()
                .isPageOpened();
        return this;
    }

}
