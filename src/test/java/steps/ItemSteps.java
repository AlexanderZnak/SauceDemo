package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ItemPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class ItemSteps {
    ItemPage itemPage;
    ProductsPage productsPage;

    public ItemSteps(WebDriver driver) {
        itemPage = new ItemPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Clicking on the product: '{itemName}' by the name")
    public ItemSteps clickByName(String itemName) {
        itemPage
                .openPage()
                .clickOnName(itemName);
        return this;
    }

    @Step("Clicking on the product: '{itemName}' by the img")
    public ItemSteps clickByImg(String itemName) {
        itemPage
                .openPage()
                .clickOnImg(itemName);
        return this;
    }

    @Step("")
    public ItemSteps clickButtonBack() {
        itemPage.clickButtonBack();
        return this;
    }

    @Step("Validate name of item: '{itemName}'")
    public ItemSteps validateItemName(String itemName) {
        assertEquals(itemPage.getItemName(), itemName);
        return this;
    }

    @Step("Validate is the products page opened")
    public ItemSteps validateIsProductsPageOpened() {
        productsPage.isPageOpened();
        return this;
    }

}
