package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static final String URL = "https://www.saucedemo.com";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract BasePage isPageOpened();

    public abstract BasePage openPage();


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
