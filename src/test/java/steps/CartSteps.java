package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CartSteps {
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public CartSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Step("Adding '{productName}' into the cart")
    public CartSteps addProductIntoCart(String productName) {
        productsPage
                .openPage()
                .addProduct(productName);
        return this;
    }

    @Step("Removing '{productName}' from the cart")
    public CartSteps removeProductFromCart(String productName) {
        productsPage
                .openPage()
                .removeProduct(productName);
        return this;
    }

    @Step("Checking product: '{productName}' is into the cart or not ")
    public CartSteps validateProductIsIntoCart(String productName) {
        boolean wasAdded = cartPage
                .goToCart()
                .itIsDisplayedOrNot(productName);
        if (wasAdded) {
            assertTrue(wasAdded);
        } else {
            assertFalse(wasAdded);
        }
        return this;
    }

    @Step("Clicking 'continue shopping' from the cart page")
    public CartSteps continueShopping() {
        cartPage
                .openPage()
                .continueShopping();
        return this;
    }

    @Step("Validate is the products page opened")
    public CartSteps validateIsProductsPageOpened() {
        productsPage.isPageOpened();
        return this;
    }

    @Step("Clicking 'checkout' from the cart page")
    public CartSteps checkout() {
        cartPage
                .openPage()
                .checkout();
        return this;
    }

    @Step("Validate is the checkout page opened")
    public CartSteps validateIsCheckoutPageOpened() {
        checkoutPage.isPageOpened();
        return this;
    }

}
