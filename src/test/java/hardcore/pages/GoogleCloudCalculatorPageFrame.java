package hardcore.pages;

import hardcore.model.CalculatorPageFrameModel;
import hardcore.model.TempMailoPageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleCloudCalculatorPageFrame extends GoogleCloudCalculatorPage {

    public static Double estimatedMonthlyCostInGoogleCalculator;
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/products/calculator";

    public GoogleCloudCalculatorPageFrame(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public GoogleCloudCalculatorPageFrame openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("calculator page opened");
        return this;
    }

    @FindBy(xpath = "//div[@title='Compute Engine' and @class='hexagon']/../../..")
    WebElement computeEngineButton;

    @FindBy(xpath = "//input[contains(@ng-model, 'quantity')]")
    WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Free')]/../../..")
    WebElement operatingSystemDropMenu;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Regular')]/../../..")
    WebElement vMClassDropDownMenu;

    @FindBy(xpath = "//*[contains(text(),'Series')]/following-sibling::md-select")
    WebElement seriesDropDownMenu;

    @FindBy(xpath = "//*[contains(text(),'Machine type')]/following-sibling::md-select")
    WebElement instanceTypeDropDown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div[8]/div/md-input-container/md-checkbox")
    WebElement addGpuCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    WebElement gpuQuantityDropDown;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement gpuTypeDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    WebElement localSSDDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location' and contains(@ng-model,'computeServer')]")
    WebElement locationDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and contains(@ng-change,'onCudChange')]")
    WebElement committedUsageDropDown;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'] [not(contains(@disabled,'disabled'))]")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')] [not(contains(@disabled,'disabled'))]")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailFieldInEstimate;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailInputButton;

    @FindBy(xpath = "//b[contains(@class,'ng-binding')and contains(text(),'Total')]")
    WebElement totalEstimatedCostInCalculator;

    @FindBy(xpath = "//iframe")
    private WebElement frame;

    public GoogleCloudCalculatorPageFrame fillCalculation(CalculatorPageFrameModel pageModel) {
        selectComputeEngine()
                .typeNumberOfInstancesWithUtil(pageModel)
                .selectOSSoftwareWithUtil(pageModel)
                .selectMachineClassWithUtil(pageModel)
                .selectSeriesWithUtil(pageModel)
                .selectInstanceWithUtil(pageModel)
                .selectCheckBoxGPUWithUtil(pageModel)
                .selectSSDWithUtil(pageModel)
                .selectLocationWithUtil(pageModel)
                .selectCommittedUsageWithUtil(pageModel);
        return this;
    }

    public GoogleCloudCalculatorPageFrame selectComputeEngine() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(computeEngineButton))
                .click();
        logger.info("Select compute engine");
        return this;
    }


    public GoogleCloudCalculatorPageFrame typeNumberOfInstancesWithUtil(CalculatorPageFrameModel pageModel) {
        numberOfInstancesField.sendKeys(pageModel.getNumberOfInstances());
        logger.info("Type instances number");
        return this;
    }

    public GoogleCloudCalculatorPageFrame selectOSSoftwareWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(operatingSystemDropMenu);
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getOperationSystem() + "')]/.."))
                .click();
        logger.info("Select OS software");
        return this;
    }

    public GoogleCloudCalculatorPageFrame selectMachineClassWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(vMClassDropDownMenu);
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//md-option[contains(.,'"
                + pageModel.getMachineClass() + "')]")).click();
        logger.info("Select machine class");
        return this;
    }

    public GoogleCloudCalculatorPageFrame selectSeriesWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(seriesDropDownMenu);
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                pageModel.getSeries() + "')]")).click();
        logger.info("Select series");
        return this;
    }

    public GoogleCloudCalculatorPageFrame selectInstanceWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(instanceTypeDropDown);
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                pageModel.getInstanceType() + "')]")).click();
        logger.info("Select instances");
        return this;
    }

    public GoogleCloudCalculatorPageFrame selectCheckBoxGPUWithUtil(CalculatorPageFrameModel pageModel) {
        clickToCheckBox(addGpuCheckBox);
        elementWaitAndClick(gpuQuantityDropDown);
        logger.info("Select gpu Quantity");
        driver.findElement(By.xpath("//md-option[contains(@ng-disabled, " +
                "'GPU')]/div[contains(text(),'" + pageModel.getNumberOfGPU() + "')]")).click();
        elementWaitAndClick(gpuTypeDropDown);
        logger.info("Select gpu Type");
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getGpuType() + "')]")).click();
        logger.info("Select GPU");
        return this;
    }


    public GoogleCloudCalculatorPageFrame selectSSDWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(localSSDDropDown);
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getSsd() + "')]")).click();
        logger.info("Select SSD");
        return this;
    }


    public GoogleCloudCalculatorPageFrame selectLocationWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(locationDropDown);
        driver.findElement(By.xpath("//div[@aria-hidden = 'false']//div[contains(text(),'" +
                pageModel.getLocation() + "')]"))
                .click();
        logger.info("Select Location");
        return this;
    }


    public GoogleCloudCalculatorPageFrame selectCommittedUsageWithUtil(CalculatorPageFrameModel pageModel) {
        openDropDownMenu(committedUsageDropDown);
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//div[contains(text(), '" +
                pageModel.getCommittedUsage() + "')]")).click();
        logger.info("Select Committed Usage");
        return this;
    }

    public GoogleCloudCalculatorPageFrame clickAddToEstimate() {
        addToEstimateButton.submit();
        logger.info("add to estimate");
        return this;
    }


    public GoogleCloudCalculatorPageFrame clickToEmailEstimate() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return this;
    }

    public GoogleCloudCalculatorPageFrame inputTempMailoInEstimate(TempMailoPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(emailFieldInEstimate))
                .sendKeys(pageModel.getEmailAddress());
        logger.info("input email " + pageModel.getEmailAddress());
        return this;
    }

    public GoogleCloudCalculatorPageFrame clickSendEmailButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(sendEmailInputButton)).click();
        logger.info("send email");
        return this;
    }

    public GoogleCloudCalculatorPageFrame getEstimatedCost() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]"),
                                Pattern.compile("USD")));
        String string = totalEstimatedCostInCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInGoogleCalculator = Double.parseDouble(string);
        logger.info("Estimated monthly cost in calculator page " + estimatedMonthlyCostInGoogleCalculator);
        return this;
    }

    protected void openDropDownMenu(WebElement openedDropDropMenu) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , openedDropDropMenu);
        while (openedDropDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(openedDropDropMenu))
                    .click();
        }
    }

    protected void clickToCheckBox(WebElement checkboxToClick) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , checkboxToClick);
        if (checkboxToClick.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(checkboxToClick))
                    .click();
        }
    }

    protected void elementWaitAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , element);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }


}
