package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.fail;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_LABEL = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking whether the login page opened")
    public LoginPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Opening login page")
    public LoginPage openPage() {
        driver.get(URL);
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Inserting username and password, then click log in")
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        AllureUtils.takeScreenshot(driver);
        return driver.findElement(ERROR_LABEL).getText();
    }

}
