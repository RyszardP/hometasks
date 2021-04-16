package hardcore.pages;

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

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TenMinutesPage extends AbstractPage {
    public static String emailAddress;
    public static String estimatedMonthlyCostInEmailString;
    public static Double estimatedMonthlyCostInEMail;
    private final String PAGE_URL = "https://10minutemail.com/";
    private final Logger logger = LogManager.getRootLogger();

    public TenMinutesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public TenMinutesPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    @FindBy(xpath = "//div[@id='mail_messages_content']//span[contains(text(),'Google')]")
    WebElement emailFromGoogleCloud;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    WebElement estimatedMonthlyCost;

    @FindBy(xpath = "//table[@class='quote']//tr[last()]/td[last()]")
    private WebElement webElementEstimatedMonthlyCostValue;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement webElementOpenEmailLink;


    private final String emailAddressId = "mail_address";

    public TenMinutesPage getAddress(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id(emailAddressId)), "value", "@"));
        emailAddress = driver.findElement(By.id(emailAddressId)).getAttribute("value");
        pageModel.setEmailAddress(emailAddress);
        logger.info("get address " + pageModel.getEmailAddress());
        return this;
    }

    public TenMinutesPage clickToMailWithSubject() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, 90).until(elementToBeClickable(
                webElementOpenEmailLink)).click();
        logger.info("open email");
        return this;
    }

    public TenMinutesPage getMessageFromTemporaryEmailService(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(estimatedMonthlyCost));
        pageModel.setEstimatedMonthlyCost(estimatedMonthlyCost.getText().replaceAll("[^0-9.]", ""));
        logger.info("Estimated monthly cost in email " + pageModel.getEstimatedMonthlyCost());
        return this;
    }

    public String getMessageFromTemporaryEmailService() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(
                webElementEstimatedMonthlyCostValue)).getText().replaceAll("[^0-9]\\.|\\.[^0-9]", "");
    }
}
