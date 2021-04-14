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

import java.util.regex.Pattern;

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

    public TenMinutesPage getAddress(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id("mail_address")), "value", "@"));
        emailAddress = driver.findElement(By.id("mail_address")).getAttribute("value");
        pageModel.setEmailAddress(emailAddress);
        logger.info("get address " + pageModel.getEmailAddress());
        return this;
    }

    public TenMinutesPage clickToMailWithSubject() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@id='mail_messages_content']//span[contains(text(),'Google')]"))).click();

        return this;
    }

    public TenMinutesPage getEstimatedMonthlyCostInEmail(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//table[@class='quote']//tr[last()]/td[last()]/h3"), Pattern.compile("USD")));
        estimatedMonthlyCost
                .getText()
                .replaceAll("[^0-9.]", "");
        logger.info("get estimated monthly cost");
        return this;
    }

    public TenMinutesPage getMessageFromTemporaryEmailService(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h3[contains(text(),'USD')]")));

        pageModel.setEstimatedMonthlyCost(estimatedMonthlyCost.getText().replaceAll("[^0-9.]", ""));

        logger.info("Estimated monthly cost in email " + pageModel.getEstimatedMonthlyCost());

        return this;
    }

}
