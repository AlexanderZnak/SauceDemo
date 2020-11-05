package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {

    @Test(description = "Finish by clicking the button 'Finish'")
    @Description("Validation of correct working functionality the button 'Finish'")
    public void finish() {
        overviewSteps
                .finish()
                .validateIsCompletePageOpened();
    }

}
