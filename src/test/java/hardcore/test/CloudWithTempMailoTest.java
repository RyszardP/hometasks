package hardcore.test;

import hardcore.model.CalculationPageModel;
import hardcore.model.GoogleCloudPageModel;
import hardcore.model.TempMailoPageModel;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudCalculatorPage;
import hardcore.pages.TempMailoPage;
import hardcore.service.CalculationPageCreator;
import hardcore.service.GoogleCloudPageCreator;
import hardcore.service.TempMailoPageCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CloudWithTempMailoTest extends CommonConditions {

    @Test
    public void openAndCheck() {

        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPageModel = CalculationPageCreator.withCredentialsFromProperty();
        TempMailoPageModel tempMailoPageModel = TempMailoPageCreator.withResultFromProperty();
        GoogleCloudCalculatorPage googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel)
                .clickOnFirstResult()
                .selectComputeEngine()
                .typeNumberOfInstancesWithUtil(calculatorPageModel)
                .selectOSSoftwareWithUtil(calculatorPageModel)
                .selectMachineClassWithUtil(calculatorPageModel)
                .selectSeriesWithUtil(calculatorPageModel)
                .selectInstanceWithUtil(calculatorPageModel)
                .selectCheckBoxGPUWithUtil(calculatorPageModel)
                .selectSSDWithUtil(calculatorPageModel)
                .selectLocationWithUtil(calculatorPageModel)
                .selectCommittedUsageWithUtil(calculatorPageModel)
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
                .inputTempMailoInEstimate(tempMailoPageModel)
                .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));

        tempMailoPage
                .clickToMailWithSubject()
                .getMessageFromTemporaryEmailService(tempMailoPageModel);

        driver.switchTo().window(tabs.get(0));

        googlePage
                .switchToFrameCalculator()
                .getEstimatedCost();

        assertThat(GoogleCloudCalculatorPage.estimatedMonthlyCostInGoogleCalculator,
                is(equalTo(TempMailoPage.estimatedMonthlyCostInEMail)));

    }
}
