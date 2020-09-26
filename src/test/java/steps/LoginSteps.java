package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login with username: '{username}', password: '{password}'")
    public LoginSteps login(String username, String password) {
        loginPage
                .openPage()
                .login(username, password);
        return this;
    }

    @Step("Validate is the products page opened")
    public LoginSteps validateIsProductsPageOpened() {
        productsPage.isPageOpened();
        return this;
    }

    @Step("Validate error message")
    public LoginSteps validateErrorMessage(String errorMessage) {
        assertEquals(loginPage.getErrorMessage(), errorMessage);
        return this;
    }

}
