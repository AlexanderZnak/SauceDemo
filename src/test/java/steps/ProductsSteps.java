package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

import static org.testng.Assert.assertTrue;

public class ProductsSteps {
    ProductsPage productsPage;

    public ProductsSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Selecting the sort: '{sortName}'")
    public ProductsSteps selectSort(String sortName) {
        productsPage
                .openPage()
                .selectByName(sortName);
        return this;
    }

    @Step("Validate sort according to sorting from A until Z")
    public ProductsSteps validateSortAtAz() {
        assertTrue(productsPage.sortAtAz());
        return this;
    }

    @Step("Validate sort according to sorting from Z until A")
    public ProductsSteps validateSortAtZa() {
        assertTrue(productsPage.sortAtZa());
        return this;
    }

    @Step("Validate sort according to sorting from Low price until High price")
    public ProductsSteps validateSortAtLtH() {
        assertTrue(productsPage.sortAtLtH());
        return this;
    }

    @Step("Validate sort according to sorting from High price until Low price")
    public ProductsSteps validateSortAtHtL() {
        assertTrue(productsPage.sortAtHtL());
        return this;
    }

}
