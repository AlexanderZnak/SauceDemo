package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test(description = "Sorting products by the selection of sort from A until Z")
    @Description("Validation of correct working the selection of sort from A until Z")
    public void sortByNameAz() {
        productsSteps
                .selectSort("Name (A to Z)")
                .validateSortAtAz();
    }

    @Test(description = "Sorting products by the selection of sort from Z until A")
    @Description("Validation of correct working the selection of sort from Z until A")
    public void sortByNameZa() {
        productsSteps
                .selectSort("Name (Z to A)")
                .validateSortAtZa();
    }

    @Test(description = "Sorting products by the selection of sort from Low price until High price")
    @Description("Validation of correct working the selection of sort from Low price until High price")
    public void sortByPriceLtH() {
        productsSteps
                .selectSort("Price (low to high)")
                .validateSortAtLtH();
    }

    @Test(description = "Sorting products by the selection of sort from High price until Low price")
    @Description("Validation of correct working the selection of sort from High price until Low price")
    public void sortByPriceHtL() {
        productsSteps
                .selectSort("Price (high to low)")
                .validateSortAtHtL();
    }

}
