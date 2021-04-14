package hardcore.test;

import hardcore.model.*;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudCalculatorPageFrame;
import hardcore.pages.TenMinutesPage;
import hardcore.service.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CloudWithTempMailoTest extends CommonConditions {

    @Test
    public void openAndCheck() {

        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        SearchResultPageModel searchResultPageModel = SearchResultPageCreator.withResultFromProperty();
        CalculatorPageFrameModel calculatorPageFrameModel = CalculatorPageFrameCreator.withCredentialsFromProperty();
        TenMinutesPageModel tenMinutesPageModel = TenMinutesPageCreator.withResultFromProperty();
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

        TenMinutesPage tenMinutesPage = new TenMinutesPage(driver)
                .openPage()
                .getAddress(tenMinutesPageModel);

        driver.switchTo().window(tabs.get(0));

        googlePage
                .switchToFrameCalculator()
                .inputTempMailoInEstimate(tenMinutesPageModel.getEmailAddress())
                .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));

       tenMinutesPage
                .clickToMailWithSubject()
                .getMessageFromTemporaryEmailService(tenMinutesPageModel);

        driver.switchTo().window(tabs.get(0));

        googlePage
                .switchToFrameCalculator()
                .getEstimatedCost();

        Assert.assertTrue((GoogleCloudCalculatorPageFrame.estimatedMonthlyCostInGoogleCalculator)
                .equals(TenMinutesPage.estimatedMonthlyCostInEMail),"true");

    }
}
