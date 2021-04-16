package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/s/results?q";

    @FindBy(xpath = "//a[@class='gs-title'][1]")
    private WebElement firstResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchResultPage openPage() {
        return this;
    }

    public GoogleCloudCalculatorPage clickOnFirstResult() {
        waitAndClickToWebElement(firstResult);
        logger.info("first result");
        return new GoogleCloudCalculatorPage(this.driver);
    }
}
