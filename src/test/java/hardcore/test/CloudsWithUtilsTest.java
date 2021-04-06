package hardcore.test;

import hardcore.model.CalculationPageModel;
import hardcore.model.GoogleCloudPageModel;
import hardcore.model.TempMailoPageModel;
import hardcore.model.TenMinutesPageModel;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudPlatformPricingCalculatorPage;
import hardcore.pages.TenMinutesPage;
import hardcore.service.CalculationPageCreator;
import hardcore.service.GoogleCloudPageCreator;
import hardcore.service.TempMailoPageCreator;
import hardcore.service.TenMinutesPageCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CloudsWithUtilsTest extends CommonConditions {

    @Test
    public void openCloudPage() {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPage = CalculationPageCreator.withCredentialsFromProperty();
        TenMinutesPageModel tenMinutesPageModel = TenMinutesPageCreator.withResultFromProperty();
        TempMailoPageModel tempMailoPage = TempMailoPageCreator.withResultFromProperty();
        GoogleCloudPlatformPricingCalculatorPage googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel)
                .clickOnFirstResult()
                .selectComputeEngine()
                .typeNumberOfInstancesWithUtil(calculatorPage)
                .selectOSSoftwareWithUtil(calculatorPage)
                .selectMachineClassWithUtil(calculatorPage)
                .selectSeriesWithUtil(calculatorPage)
                .selectInstanceWithUtil(calculatorPage)
                .selectCheckBoxGPUWithUtil(calculatorPage)
                .selectSSDWithUtil(calculatorPage)
                .selectLocationWithUtil(calculatorPage)
                .selectCommittedUsageWithUtil(calculatorPage)
                .clickAddToEstimate()
                .clickToEmailEstimate()
                .createNewTab()
                .switchTab();

        TenMinutesPage tenMinutesPage = new TenMinutesPage(driver)
                .openPage()
                .getAddress(tenMinutesPageModel)
                .switchTabToCalculate();

        googlePage
                .switchToFrameCalculator()
                .inputTenMinutesEmailInEstimate(tenMinutesPageModel)
                .clickSendEmailButton()
                .switchTab();

        tenMinutesPage
                .clickToMailWithSubject()
                .getMessageFromTemporaryEmailService(tenMinutesPageModel)
                .switchTabToCalculate();

        googlePage
                .switchToFrameCalculator()
                .getEstimatedCost();

        assertThat(GoogleCloudPlatformPricingCalculatorPage.estimatedMonthlyCostInGoogleCalculator,
                is(equalTo(TenMinutesPage.estimatedMonthlyCostInEmailString)));
    }
}
