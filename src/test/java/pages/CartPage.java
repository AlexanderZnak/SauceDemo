package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.fail;

public class CartPage extends BasePage {
    public static final By CART = By.cssSelector("[data-icon='shopping-cart']");
    public static final By CONTINUE_SHOPPING = By.cssSelector("[class='btn_secondary']");
    public static final By CHECKOUT = By.cssSelector("[class='btn_action checkout_button']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking whether the cart page opened")
    public CartPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_SHOPPING));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Opening cart page")
    public CartPage openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Go to cart page")
    public ProductsPage goToCart() {
        driver.findElement(CART).click();
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    @Step("Continue shopping")
    public ProductsPage continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    @Step("Checkout")
    public CheckoutPage checkout() {
        driver.findElement(CHECKOUT).click();
        AllureUtils.takeScreenshot(driver);
        return new CheckoutPage(driver);
    }

}
