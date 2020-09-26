package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public final static String USERNAME = "standard_user";
    public final static String PASSWORD = "secret_sauce";
    WebDriver driver;
    CheckoutSteps checkoutSteps;
    CartSteps cartSteps;
    ItemSteps itemSteps;
    LoginSteps loginSteps;
    MenuSteps menuSteps;
    OverviewSteps overviewSteps;
    ProductsSteps productsSteps;

    @BeforeMethod(alwaysRun = true)
    public void openAll(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        checkoutSteps = new CheckoutSteps(driver);
        cartSteps = new CartSteps(driver);
        itemSteps = new ItemSteps(driver);
        loginSteps = new LoginSteps(driver);
        menuSteps = new MenuSteps(driver);
        overviewSteps = new OverviewSteps(driver);
        productsSteps = new ProductsSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
