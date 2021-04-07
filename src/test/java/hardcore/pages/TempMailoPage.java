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

import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TempMailoPage extends AbstractPage {

    public static String emailAddress;
    public static String estimatedMonthlyCostInEmailString;
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

    @FindBy(xpath = "//div[@class='mail-item-sub'][contains(text(),'Google')]")
    WebElement emailFromGoogleCloud;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    WebElement estimatedMonthlyCost;

    @FindBy(xpath = "//iframe[@id='fullmessage']")
    private WebElement frame;

    public TempMailoPage getAddress(TempMailoPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id("i-email")), "value", "@"));
        emailAddress = driver.findElement(By.id("i-email")).getAttribute("value");
        pageModel.setEmailAddress(emailAddress);
        logger.info("get address " + pageModel.getEmailAddress());
        return this;
    }

    public TempMailoPage switchTabToCalculate() {
        driver.switchTo().window(GoogleCloudCalculatorPage.tabs.get(0));
        return this;
    }

    public TempMailoPage clickToMailWithSubject() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@class='mail-item-sub'][contains(text(),'Google')]"))).click();
        logger.info("click to mail with subject ");
        return this;
    }

    public TempMailoPage clickToHelloMessage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@class='mail-item-sub'][contains(text(),'Welcome')]"))).click();
        logger.info("click to mail with hello message ");
        return this;
    }

    public TempMailoPage findHello() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(frame);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(text(),'All the best')]")));

        return this;
    }

    public TempMailoPage getEstimatedMonthlyCostInEmail(TempMailoPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(frame);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//table[@class='quote']//tr[last()]/td[last()]/h3"), Pattern.compile("USD")));
        estimatedMonthlyCost
                .getText()
                .replaceAll("[^0-9.]", "");
        logger.info("get estimated monthly cost");
        return this;
    }

    public TempMailoPage getMessageFromTemporaryEmailService(TempMailoPageModel pageModel) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(frame);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h3[contains(text(),'USD')]")));
        logger.info("USD is visible");
        System.out.println("USD is visible");
        System.out.println(estimatedMonthlyCost.getText());
        pageModel.setEstimatedMonthlyCost(estimatedMonthlyCost.getText().replaceAll("[^0-9.]", ""));
        System.out.println(pageModel.getEstimatedMonthlyCost());
        logger.info("Estimated monthly cost in email " + pageModel.getEstimatedMonthlyCost());
        return this;
    }
}
