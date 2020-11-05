package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.fail;

public class CheckoutPage extends BasePage {
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE = By.cssSelector(".btn_primary.cart_button");
    public static final By CANCEL = By.cssSelector(".cart_cancel_link.btn_secondary");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking whether the checkout page opened")
    public CheckoutPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Opening checkout page")
    public CheckoutPage openPage() {
        driver.get(URL + "/checkout-step-one.html");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Inserting data first name, last name, zip code and click Continue")
    public CheckoutPage insertData(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Cancel the checkout")
    public CartPage cancel() {
        driver.findElement(CANCEL).click();
        AllureUtils.takeScreenshot(driver);
        return new CartPage(driver);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        try {
            AllureUtils.takeScreenshot(driver);
            return new LoginPage(driver).getErrorMessage();
        } catch (NoSuchElementException e) {
            return "Error haven't appeared";
        }
    }

}
