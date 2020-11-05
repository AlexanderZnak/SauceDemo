package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.AllureUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.fail;

public class ProductsPage extends BasePage {
    public static final By LOCATORS_FOR_NAMES = By.cssSelector(".inventory_item_name");
    public static final By LOCATORS_FOR_PRICES = By.cssSelector(".inventory_item_price");
    public static final By SELECT_FOR_SORT = By.cssSelector(".product_sort_container");
    String productLocatorForAdd = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String productLocatorForRemove = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='REMOVE']";
    String nameOfItem = "//*[text()='%s']";
    String locatorForClickByImg = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//img[@class='inventory_item_img']";
    ArrayList<WebElement> products;
    List<WebElement> items;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking whether the products page opened")
    public ProductsPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_FOR_SORT));

        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Opening products page")
    public ProductsPage openPage() {
        driver.get(URL + "/inventory.html");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Adding product")
    public CartPage addProduct(String product) {
        driver.findElement(By.xpath(String.format(productLocatorForAdd, product))).click();
        AllureUtils.takeScreenshot(driver);
        return new CartPage(driver);
    }

    @Step("Removing product")
    public CartPage removeProduct(String product) {
        addProduct(product);
        driver.findElement(By.xpath(String.format(productLocatorForRemove, product))).click();
        AllureUtils.takeScreenshot(driver);
        return new CartPage(driver);
    }

    @Step("Sort from A until Z")
    public boolean sortAtAz() {
        items = driver.findElements(LOCATORS_FOR_NAMES);
        products = new ArrayList<WebElement>(items);
        Collections.sort(products, new Comparator<WebElement>() {
            public int compare(WebElement o1, WebElement o2) {
                return o1.getText().compareTo(o2.getText());
            }
        });
        AllureUtils.takeScreenshot(driver);
        return cycleForSort();
    }

    @Step("Sort from Z until A")
    public boolean sortAtZa() {
        items = driver.findElements(LOCATORS_FOR_NAMES);
        products = new ArrayList<WebElement>(items);
        Collections.sort(products, new Comparator<WebElement>() {
            public int compare(WebElement o1, WebElement o2) {
                return o2.getText().compareTo(o1.getText());
            }
        });
        AllureUtils.takeScreenshot(driver);
        return cycleForSort();
    }

    @Step("Sort from low price until high price")
    public boolean sortAtLtH() {
        items = driver.findElements(LOCATORS_FOR_PRICES);
        products = new ArrayList<WebElement>(items);
        Collections.sort(products, new Comparator<WebElement>() {
            public int compare(WebElement o1, WebElement o2) {
                String a = o1.getText().substring(1);
                String b = o2.getText().substring(1);
                return (int) (Double.parseDouble(a) - Double.parseDouble(b));
            }
        });
        AllureUtils.takeScreenshot(driver);
        return cycleForSort();
    }

    @Step("Sort from high price until low price")
    public boolean sortAtHtL() {
        items = driver.findElements(LOCATORS_FOR_PRICES);
        products = new ArrayList<WebElement>(items);
        Collections.sort(products, new Comparator<WebElement>() {
            public int compare(WebElement o1, WebElement o2) {
                String a = o1.getText().substring(1);
                String b = o2.getText().substring(1);
                return (int) (Double.parseDouble(b) - Double.parseDouble(a));
            }
        });
        AllureUtils.takeScreenshot(driver);
        return cycleForSort();
    }

    @Step("Checking whether product is into the cart")
    public boolean itIsDisplayedOrNot(String productName) {
        try {
            boolean a = false;
            if (driver.findElement(By.xpath(String.format(nameOfItem, productName))).getText().equals(productName)) {
                a = true;
            }
            AllureUtils.takeScreenshot(driver);
            return a;

        } catch (NoSuchElementException e) {
            AllureUtils.takeScreenshot(driver);
            return false;
        }
    }

    @Step("Checking the sort was true or false")
    public boolean cycleForSort() {
        boolean a = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(items.get(i))) {
                a = true;
            } else {
                a = false;
                break;
            }
        }
        AllureUtils.takeScreenshot(driver);
        return a;
    }

    @Step("Selecting some sort")
    public ProductsPage selectByName(String selectName) {
        Select select = new Select(driver.findElement(SELECT_FOR_SORT));
        select.selectByVisibleText(selectName);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Clicking on the product by the name")
    public ItemPage clickOnName(String productName) {
        driver.findElement(By.xpath(String.format(nameOfItem, productName))).click();
        AllureUtils.takeScreenshot(driver);
        return new ItemPage(driver);
    }

    @Step("Clicking on the product by the image")
    public ItemPage clickOnImg(String productName) {
        driver.findElement(By.xpath(String.format(locatorForClickByImg, productName))).click();
        AllureUtils.takeScreenshot(driver);
        return new ItemPage(driver);
    }

}
