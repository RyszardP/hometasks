package hardcore.test;


import hardcore.model.CalculationPageModel;
import org.testng.annotations.Test;
import hardcore.pages.GoogleCloudCalculatorPage;
import hardcore.service.CalculationPageCreator;

public class WithSimpleCalculatorTest extends CommonConditions {

    @Test
    public void openCalculatorPage() {
        CalculationPageModel calculatorPageModel = CalculationPageCreator.withCredentialsFromProperty();
        GoogleCloudCalculatorPage googlePage = new GoogleCloudCalculatorPage(driver)
                .openPage()
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
    }

}
