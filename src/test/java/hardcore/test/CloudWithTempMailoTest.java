package hardcore.test;

import hardcore.model.CalculatorPageFrameModel;
import hardcore.model.GoogleCloudPageModel;
import hardcore.model.TempMailoPageModel;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudCalculatorPageFrame;
import hardcore.pages.TempMailoPage;
import hardcore.service.CalculatorPageFrameCreator;
import hardcore.service.GoogleCloudPageCreator;
import hardcore.service.TempMailoPageCreator;
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
        CalculatorPageFrameModel calculatorPageFrameModel = CalculatorPageFrameCreator.withCredentialsFromProperty();
        TempMailoPageModel tempMailoPageModel = TempMailoPageCreator.withResultFromProperty();
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

        TempMailoPage tempMailoPage = new TempMailoPage(driver)
                .openPage()
                .getAddress(tempMailoPageModel);

        driver.switchTo().window(tabs.get(0));

        googlePage
                .switchToFrameCalculator()
                .inputTempMailoInEstimate(tempMailoPageModel.getEmailAddress())
                .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));

        //   String totalPostEstimatedCostResult = tempMailoPage
        tempMailoPage
                .clickToMailWithSubject()
                .getMessageFromTemporaryEmailService(tempMailoPageModel);

        //   System.out.println(totalPostEstimatedCostResult);

        //   logger.info("totalPostEstimatedCostResult " + totalPostEstimatedCostResult);

        driver.switchTo().window(tabs.get(0));

        String estimatedMonthlyCostInGoogleCalculator = googlePage
                .switchToFrameCalculator()
                .getEstimateCost();

        logger.info("estimatedMonthlyCostInGoogleCalculator" + estimatedMonthlyCostInGoogleCalculator);

        Assert.assertTrue((GoogleCloudCalculatorPageFrame.estimatedMonthlyCostInGoogleCalculator)
                .equals(TempMailoPage.estimatedMonthlyCostInEMail), "true");

    }
}
