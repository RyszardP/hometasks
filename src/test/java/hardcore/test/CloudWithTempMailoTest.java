package hardcore.test;

import hardcore.model.*;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudCalculatorPageFrame;
import hardcore.pages.TenMinutesPage;
import hardcore.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CloudWithTempMailoTest extends CommonConditions {

    private final Logger logger = LogManager.getRootLogger();

    @Test
    public void openAndCheck() {

        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        SearchResultPageModel searchResultPageModel = SearchResultPageCreator.withResultFromProperty();
        CalculatorPageFrameModel calculatorPageFrameModel = CalculatorPageFrameCreator.withCredentialsFromProperty();
        TenMinutesPageModel tenMinutesPageModel = TenMinutesPageCreator.withResultFromProperty();
        GoogleCloudCalculatorPageFrame googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel.getSearch())
                .clickOnFirstResult()
                .switchToFrameCalculator()
                .fillCalculation(calculatorPageFrameModel)
                .clickAddToEstimate()
                .clickToEmailEstimate();

        ((JavascriptExecutor) driver).executeScript("window.open()");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        TenMinutesPage tenMinutesPage = new TenMinutesPage(driver)
                .openPage()
                .getAddress(tenMinutesPageModel);

        driver.switchTo().window(tabs.get(0));

        googlePage
                .switchToFrameCalculator()
                .inputTempMailoInEstimate(tenMinutesPageModel.getEmailAddress())
                .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));

        String totalPostEstimatedCostResult = tenMinutesPage
                .clickToMailWithSubject()
                .getMessageFromTemporaryEmailService();

        logger.info(totalPostEstimatedCostResult + " totalPostEstimatedCostResult");

        driver.switchTo().window(tabs.get(0));

        String totalPostEstimatedCostResultInCalculator = googlePage
                .switchToFrameCalculator()
                .getTotalEstimatedCostResult();

        logger.info(totalPostEstimatedCostResultInCalculator + " totalPostEstimatedCostResultInCalculator");

        Assert.assertTrue(totalPostEstimatedCostResult.contains(totalPostEstimatedCostResultInCalculator));

    }
}
