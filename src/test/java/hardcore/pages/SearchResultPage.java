package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/s/results?q";

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchResultPage openPage() {
        return this;
    }

    public GoogleCloudCalculatorPage clickOnFirstResult() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='gs-title'][1]")));
        WebElement findElement = driver.findElement(By.xpath("//a[@class='gs-title'][1]"));
        findElement.click();
        logger.info("first result");
        return new GoogleCloudCalculatorPage(this.driver);
    }
}
