package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/products/calculator";


    @FindBy(xpath = "//iframe")
    private WebElement frame;

    @Override
    public GoogleCloudCalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudCalculatorPageFrame switchToFrameCalculator() {
        waitAndSwitchToFrame(frame);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.switchTo().frame(0);
        logger.info("switch to frame");
        return new GoogleCloudCalculatorPageFrame(this.driver);
    }

    public GoogleCloudCalculatorPage switchToDefaultFrame() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().defaultContent();
        return new GoogleCloudCalculatorPage(this.driver);
    }

}
