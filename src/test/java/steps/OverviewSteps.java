package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.OverviewPage;

public class OverviewSteps {
    OverviewPage overviewPage;

    public OverviewSteps(WebDriver driver) {
        overviewPage = new OverviewPage(driver);
    }

    @Step("Finishing order by clicking the button 'FINISH'")
    public OverviewSteps finish() {
        overviewPage
                .openPage()
                .finish();
        return this;
    }

    @Step("Validate is the complete page opened")
    public OverviewSteps validateIsCompletePageOpened() {
        overviewPage.isCompletePageOpened();
        return this;
    }

}
