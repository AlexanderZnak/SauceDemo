package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class OverviewPage extends BasePage {
    public static final By BUTTON_FINISH = By.cssSelector(".btn_action.cart_button");
    public static final By COMPLETE = By.id("checkout_complete_container");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking whether the overview page opened")
    public OverviewPage isPageOpened() {
        AllureUtils.takeScreenshot(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_FINISH));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Opening overview page")
    public OverviewPage openPage() {
        driver.get(URL + "/checkout-step-two.html");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Finish order")
    public OverviewPage finish() {
        driver.findElement(BUTTON_FINISH).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the complete page opened")
    public OverviewPage isCompletePageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMPLETE));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
