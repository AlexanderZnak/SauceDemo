package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ItemTest extends BaseTest {

    @Test(description = "Correct of description the product clicking on the name")
    @Description("Validation of according the name of product with description clicking on the name")
    public void checkDescriptionByLinkName() {
        itemSteps
                .clickByName("Sauce Labs Bolt T-Shirt")
                .validateItemName("Sauce Labs Bolt T-Shirt");
    }

    @Test(description = "Correct of description the product clicking on the image")
    @Description("Validation of according the name of product with description clicking on the image")
    public void checkDescriptionByLinkImg() {
        itemSteps
                .clickByImg("Sauce Labs Bolt T-Shirt")
                .validateItemName("Sauce Labs Bolt T-Shirt");
    }

    @Test(description = "Back by clicking the button 'Back'")
    @Description("Validation of correct working functionality the button 'Back'")
    public void buttonBack() {
        itemSteps
                .clickByName("Sauce Labs Bolt T-Shirt")
                .clickButtonBack()
                .validateIsProductsPageOpened();
    }

}
