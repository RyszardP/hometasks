package hardcore.test;


import hardcore.model.CalculatorPageFrameModel;
import hardcore.model.GoogleCloudPageModel;
import hardcore.service.CalculatorPageFrameCreator;
import hardcore.service.GoogleCloudPageCreator;
import org.testng.annotations.Test;

public class WithSimpleCalculatorTest extends CommonConditions {

    @Test
    public void openCalculatorPage() {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculatorPageFrameModel calculatorPageFrameModel = CalculatorPageFrameCreator.withCredentialsFromProperty();
 /*       GoogleCloudCalculatorPageFrame googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel.getSearch())
                .clickOnFirstResult()
                .selectComputeEngine()
                .typeNumberOfInstancesWithUtil(calculatorPageFrameModel)
                .selectOSSoftwareWithUtil(calculatorPageFrameModel)
                .selectMachineClassWithUtil(calculatorPageFrameModel)
                .selectSeriesWithUtil(calculatorPageFrameModel)
                .selectInstanceWithUtil(calculatorPageFrameModel)
                .selectCheckBoxGPUWithUtil(calculatorPageFrameModel)
                .selectSSDWithUtil(calculatorPageFrameModel)
                .selectLocationWithUtil(calculatorPageFrameModel)
                .selectCommittedUsageWithUtil(calculatorPageFrameModel)
                .clickAddToEstimate()
                .clickToEmailEstimate();*/
    }

}
