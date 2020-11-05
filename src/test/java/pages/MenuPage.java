package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class MenuPage extends BasePage {
    public static final By MENU_BUTTON = By.xpath("//button[text()='Open Menu']");
    public static final By CLOSE_MENU = By.xpath("//button[contains(text(),'Close Menu')]");
    String linkOfMenu = "//a[contains(text(),'%s')]";

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Deprecated
    public MenuPage isPageOpened() {
        return this;
    }

    @Deprecated
    public MenuPage openPage() {
        return this;
    }

    @Step("Click on the burger menu")
    public MenuPage clickMenu() {
        driver.findElement(MENU_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Add product, open burger menu, click Reset app State, close burger menu")
    public CartPage resetAddedProducts(String link) {
        new ProductsPage(driver)
                .openPage()
                .addProduct("Sauce Labs Bike Light");
        new MenuPage(driver)
                .clickMenu()
                .goToLink(link)
                .closeMenu();
        AllureUtils.takeScreenshot(driver);
        return new CartPage(driver);
    }

    @Step("Select some sort and click burger menu")
    public MenuPage selectSortAndClickMenu() {
        new ProductsPage(driver)
                .openPage()
                .selectByName("Name (Z to A)");
        clickMenu();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the login page opened")
    public MenuPage isLoginPageOpened() {
        new LoginPage(driver).isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Go to the link in the burger menu")
    public MenuPage goToLink(String linkName) {
        driver.findElement(By.xpath(String.format(linkOfMenu, linkName))).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Close burger menu")
    public ProductsPage closeMenu() {
        driver.findElement(CLOSE_MENU).click();
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

}
