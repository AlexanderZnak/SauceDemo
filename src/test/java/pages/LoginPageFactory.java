package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    WebElement errorLabel;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public LoginPageFactory isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        return this;
    }

    public LoginPageFactory openPage() {
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
        isPageOpened();
        return this;
    }

    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorLabel.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
