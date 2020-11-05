package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class ItemPage extends BasePage {
    public static final By ITEM_NAME = By.cssSelector(".inventory_details_name");
    public static final By BUTTON_BACK = By.cssSelector(".inventory_details_back_button");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Deprecated
    public ItemPage isPageOpened() {
        return this;
    }

    @Deprecated
    public ItemPage openPage() {
        return this;
    }

    @Step("Get name of item")
    public String getItemName() {
        AllureUtils.takeScreenshot(driver);
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Clicking the button back")
    public ItemPage clickButtonBack() {
        driver.findElement(BUTTON_BACK).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
