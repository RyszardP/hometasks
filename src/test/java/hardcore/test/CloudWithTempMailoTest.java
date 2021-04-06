package hardcore.test;

import hardcore.model.CalculationPageModel;
import hardcore.model.GoogleCloudPageModel;
import hardcore.model.TempMailoPageModel;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudPlatformPricingCalculatorPage;
import hardcore.pages.TempMailoPage;
import hardcore.service.CalculationPageCreator;
import hardcore.service.GoogleCloudPageCreator;
import hardcore.service.TempMailoPageCreator;
import org.testng.annotations.Test;

public class CloudWithTempMailoTest extends CommonConditions {

    @Test
    public void openAndCheck()  {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPageModel = CalculationPageCreator.withCredentialsFromProperty();
        TempMailoPageModel tempMailoPageModel = TempMailoPageCreator.withResultFromProperty();
        GoogleCloudPlatformPricingCalculatorPage googlePage = new CloudGooglePage(driver)
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
                .clickToEmailEstimate()
                .createNewTab()
                .switchTab();




        TempMailoPage tempMailoPage = new TempMailoPage(driver)
                .openPage()
                .getAddress(tempMailoPageModel)
                .switchTabToCalculate();

        googlePage
                .switchToFrameCalculator()
                .inputTempMailoInEstimate(tempMailoPageModel)
                .clickSendEmailButton()
                .switchTab();

    }
}
