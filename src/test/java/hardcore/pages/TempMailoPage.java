package hardcore.pages;

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

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TempMailoPage extends AbstractPage {

    public static String emailAddress;
    public static Double estimatedMonthlyCostInEMail;
    private final String PAGE_URL = "https://tempmailo.com/";
    private final Logger logger = LogManager.getRootLogger();

    public TempMailoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public TempMailoPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    private final String emailID = "i-email";
    private final String subjectImEmail = "//div[@class='mail-item-sub'][contains(text(),'Google')]";

    @FindBy(xpath = "//table[@class='quote']//tr[last()]/td[last()]")
    WebElement fieldWithUSD;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    WebElement estimatedMonthlyCost;

    @FindBy(xpath = "//iframe[@id='fullmessage']")
    private WebElement frame;

    public TempMailoPage getAddress(TempMailoPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id(emailID)), "value", "@"));
        emailAddress = driver.findElement(By.id(emailID)).getAttribute("value");
        pageModel.setEmailAddress(emailAddress);
        logger.info("get address " + pageModel.getEmailAddress());
        return this;
    }

    public TempMailoPage clickToMailWithSubject() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath(subjectImEmail))).click();
        logger.info("click to mail with subject");
        return this;
    }

    public TempMailoPage getMessageFromTemporaryEmailService(TempMailoPageModel pageModel) {
        waitAndSwitchToFrame(frame);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.valueOf(estimatedMonthlyCost))));
        logger.info("USD is visible");
        pageModel.setEstimatedMonthlyCost(estimatedMonthlyCost.getText().replaceAll("[^0-9.]", ""));
        estimatedMonthlyCostInEMail = Double.parseDouble(pageModel.getEstimatedMonthlyCost());
        logger.info("Estimated monthly cost in email " + estimatedMonthlyCostInEMail);
        return this;
    }

    public String getMessageFromTemporaryEmailService() {
        waitAndSwitchToFrame(frame);
        logger.info("switch to mail");
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(fieldWithUSD))
                .getText().replaceAll("[^0-9.]", "");
    }
}
