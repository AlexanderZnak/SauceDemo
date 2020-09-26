package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test(description = "Adding product into the cart")
    @Description("Validation of adding the product into the cart")
    public void itemShouldBeAddedIntoCart() {
        cartSteps
                .addProductIntoCart("Sauce Labs Bike Light")
                .validateProductIsIntoCart("Sauce Labs Bike Light");
    }

    @Test(description = "Removing product from the cart")
    @Description("Validation of removing the product from the cart")
    public void itemShouldBeRemovedFromCart() {
        cartSteps
                .removeProductFromCart("Sauce Labs Bike Light")
                .validateProductIsIntoCart("Sauce Labs Bike Light");
    }

    @Test(description = "Continue shopping by clicking the button 'Continue Shopping'")
    @Description("Validation of correct working functionality the button 'Continue Shopping'")
    public void continueShopping() {
        cartSteps
                .continueShopping()
                .validateIsProductsPageOpened();
    }

    @Test(description = "Checkout by clicking the button 'Checkout'")
    @Description("Validation of correct working functionality the button 'Checkout'")
    public void checkout() {
        cartSteps
                .checkout()
                .validateIsCheckoutPageOpened();
    }

}
