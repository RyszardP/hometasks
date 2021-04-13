package hardcore.test;


import hardcore.model.CalculatorPageFrameModel;
import hardcore.model.GoogleCloudPageModel;
import hardcore.pages.CloudGooglePage;
import hardcore.pages.GoogleCloudCalculatorPageFrame;
import hardcore.service.CalculatorPageFrameCreator;
import hardcore.service.GoogleCloudPageCreator;

public class WithSimpleCalculatorTest extends CommonConditions {

    //  @Test
    public void openCalculatorPage() {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculatorPageFrameModel calculatorPageFrameModel = CalculatorPageFrameCreator.withCredentialsFromProperty();
        GoogleCloudCalculatorPageFrame googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel.getSearch())
                .clickOnFirstResult()
                .switchToFrameCalculator()
                .fillCalculation(calculatorPageFrameModel)
                .clickAddToEstimate()
                .clickToEmailEstimate();
    }

}
