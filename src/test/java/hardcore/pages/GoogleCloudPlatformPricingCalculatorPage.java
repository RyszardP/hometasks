package hardcore.pages;

import hardcore.model.CalculationPageModel;
import hardcore.model.TempMailoPageModel;
import hardcore.model.TenMinutesPageModel;
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

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {

    public static ArrayList<String> tabs;
    public static Double estimatedMonthlyCostInGoogleCalculator;
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//div[@title='Compute Engine' and @class='hexagon']/../../..")
    WebElement computeEngineButton;

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::*[@role='tab']")
    WebElement computeEngineSectionParent;

    @FindBy(xpath = "//div[@title='Cloud Storage' and @class='hexagon']/../../..")
    WebElement cloudStorageButton;

    @FindBy(xpath = "//label[text()='Number of instances']")
    WebElement gKESection;

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

    @FindBy(xpath = "//button[@aria-label='Email Estimate'] [not(contains(@disabled,'disabled'))]")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailFieldInEstimate;

    @FindBy(xpath = "//button[@aria-label='Send Email'][not(contains(@disabled,'disabled'))]")
    WebElement sendEmailButtonInEstimate;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailInputButton;

    @FindBy(xpath = "//b[contains(@class,'ng-binding')and contains(text(),'Total')]")
    WebElement totalEstimatedCostInCalculator;

    @FindBy(xpath = "//iframe")
    private WebElement frame;


    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public GoogleCloudPlatformPricingCalculatorPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Calculator page opened");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectComputeEngine() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        while (computeEngineButton.getAttribute("aria-selected").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(computeEngineButton))
                    .click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnCloudStorage() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        while (cloudStorageButton.getAttribute("aria-selected").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(cloudStorageButton))
                    .click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstances(Integer quantity) {
        numberOfInstancesField.sendKeys(quantity.toString());
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstancesWithUtil(CalculationPageModel pageModel) {
        numberOfInstancesField.sendKeys(pageModel.getNumberOfInstances());
        logger.info("Type instances number");
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectOSSoftware(String oS) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , operatingSystemDropMenu);
        while (operatingSystemDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(operatingSystemDropMenu))
                    .click();
        }
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + oS + "')]/..")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectOSSoftwareWithUtil(CalculationPageModel pageModel) {
        while (operatingSystemDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(operatingSystemDropMenu))
                    .click();
        }
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getOperationSystem() + "')]/..")).click();
        logger.info("Select OS software");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineClass(String machineClass) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , vMClassDropDownMenu);
        while (vMClassDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(vMClassDropDownMenu))
                    .click();
        }

        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//md-option[contains(.,'"
                + machineClass + "')]")).click();
        logger.info("Select machine class");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineClassWithUtil(CalculationPageModel pageModel) {
        while (vMClassDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(vMClassDropDownMenu))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//md-option[contains(.,'"
                + pageModel.getMachineClass() + "')]")).click();
        logger.info("Select machine class");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSeries(String series) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , seriesDropDownMenu);

        while (seriesDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(seriesDropDownMenu))
                    .click();
        }


        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" + series + "')]")).click();
        logger.info("Select series");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSeriesWithUtil(CalculationPageModel pageModel) {
        while (seriesDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(seriesDropDownMenu))
                    .click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seriesDropDownMenu);
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                pageModel.getSeries() + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectInstance(String typeOfMachine) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , instanceTypeDropDown);

        while (instanceTypeDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(instanceTypeDropDown))
                    .click();
        }


        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                typeOfMachine + "')]")).click();
        logger.info("Select instances");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectInstanceWithUtil(CalculationPageModel pageModel) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , instanceTypeDropDown);

        while (instanceTypeDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(instanceTypeDropDown))
                    .click();
        }

        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                pageModel.getInstanceType() + "')]")).click();
        logger.info("Select instances");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectCheckBoxGPU(Integer numberOfGPUs, String gpuType) {
        if (addGpuCheckBox.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(addGpuCheckBox))
                    .click();
        }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(gpuQuantityDropDown)).click();

        driver.findElement(By.xpath("//md-option[contains(@ng-disabled, " +
                "'GPU')]/div[contains(text(),'" + numberOfGPUs + "')]")).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(gpuTypeDropDown)).click();
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + gpuType + "')]")).click();
        logger.info("Select GPU");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectCheckBoxGPUWithUtil(CalculationPageModel pageModel) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , addGpuCheckBox);

        if (addGpuCheckBox.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(addGpuCheckBox))
                    .click();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , gpuQuantityDropDown);


        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuQuantityDropDown)).click();
        driver.findElement(By.xpath("//md-option[contains(@ng-disabled, " +
                "'GPU')]/div[contains(text(),'" + pageModel.getNumberOfGPU() + "')]")).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , gpuTypeDropDown);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuTypeDropDown)).click();
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getGpuType() + "')]")).click();
        logger.info("Select GPU");
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectSSD(String localSSD) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , localSSDDropDown);

        while (localSSDDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(localSSDDropDown))
                    .click();
        }


        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + localSSD + "')]")).click();
        logger.info("Select SSD");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSSDWithUtil(CalculationPageModel pageModel) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , localSSDDropDown);

        while (localSSDDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(localSSDDropDown))
                    .click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", localSSDDropDown);
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getSsd() + "')]")).click();
        logger.info("Select SSD");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectLocation(String location) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , locationDropDown);

        while (locationDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            locationDropDown.click();
        }


        driver.findElement(By.xpath("//div[@aria-hidden = 'false']//div[contains(text(),'" +
                location + "')]"))
                .click();
        logger.info("Select Location");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectLocationWithUtil(CalculationPageModel pageModel) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , locationDropDown);

        while (locationDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            locationDropDown.click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationDropDown);
        driver.findElement(By.xpath("//div[@aria-hidden = 'false']//div[contains(text(),'" +
                pageModel.getLocation() + "')]"))
                .click();
        logger.info("Select Location");
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectCommittedUsage(String usage) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , committedUsageDropDown);

        while (committedUsageDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(committedUsageDropDown))
                    .click();
        }


        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//div[contains(text(), '" + usage + "')]")).click();
        logger.info("Select Committed Usage");
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectCommittedUsageWithUtil(CalculationPageModel pageModel) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , committedUsageDropDown);

        while (committedUsageDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(committedUsageDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//div[contains(text(), '" +
                pageModel.getCommittedUsage() + "')]")).click();
        logger.info("Select Committed Usage");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickAddToEstimate() {
        addToEstimateButton.submit();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage switchTab() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage switchTabAndWait() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage returnTabWithCalc(){
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage switchToFrameCalculator() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 15);
        driver.switchTo().frame(0);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickToEmailEstimate() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage inputTenMinutesEmailInEstimate(TenMinutesPageModel pageModel) {
        //  hardcore.driver.switchTo().defaultContent();
        //  ((JavascriptExecutor) hardcore.driver).executeScript("arguments[0].scrollIntoView(true);", emailFieldInEstimate);
        new WebDriverWait(driver, 15).until(visibilityOf(emailFieldInEstimate))
                .sendKeys(pageModel.getEmailAddress());
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage inputTempMailoInEstimate(TempMailoPageModel pageModel) {
        new WebDriverWait(driver, 15).until(visibilityOf(emailFieldInEstimate))
                .sendKeys(pageModel.getEmailAddress());
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickSendEmailButton() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(sendEmailInputButton)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage getEstimatedCost() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]"),
                                Pattern.compile("USD")));
        String string = totalEstimatedCostInCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInGoogleCalculator = Double.parseDouble(string);
        logger.info("Estimated monthly cost in calculator " + estimatedMonthlyCostInGoogleCalculator);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage getEstimatedCostString() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(totalEstimatedCostInCalculator));
        return this;
    }
}
