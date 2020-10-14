package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.MenuPage;
import pages.ProductsPage;

import static org.testng.Assert.*;

public class MenuSteps {
    MenuPage menuPage;
    ProductsPage productsPage;
    CartPage cartPage;

    public MenuSteps(WebDriver driver) {
        menuPage = new MenuPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Step("Going to link: '{linkName}' from the burger menu")
    public MenuSteps goToLink(String linkName) {
        productsPage
                .openPage();
        menuPage
                .clickMenu()
                .goToLink(linkName);
        return this;
    }

    @Step("Validate url: '{url}' is opened")
    public MenuSteps validateUrlIsOpened(String url) {
        assertEquals(menuPage.getCurrentUrl(), url);
        return this;
    }

    @Step("Validate is the login page opened")
    public MenuSteps validateIsLoginPageOpened() {
        menuPage.isLoginPageOpened();
        return this;
    }

    @Step("Resetting added products by the link: '{link}'")
    public MenuSteps resetAddedProductsByLink(String link) {
        menuPage.resetAddedProducts(link);
        return this;
    }

    @Step("Validate is the products page opened")
    public MenuSteps validateIsProductsPageOpened() {
        productsPage.isPageOpened();
        return this;
    }

    @Step("Resetting sorted products by the link: '{link}'")
    public MenuSteps resetSortedProductByLink(String link) {
        menuPage
                .selectSortAndClickMenu()
                .goToLink(link)
                .closeMenu();
        return this;
    }

    @Step("Validating the default sort")
    public MenuSteps validateSortShouldBeGetDefault() {
        assertTrue(productsPage.sortAtAz());
        return this;
    }

    @Step("Checking product: '{productName}' is into the cart or not ")
    public MenuSteps validateProductIsIntoCart(String productName) {
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

}
