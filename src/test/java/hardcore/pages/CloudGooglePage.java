package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGooglePage extends AbstractPage {

    final private String CLOUD_URL = "https://cloud.google.com/";
    final private String CALCULATOR_LINK = "Google Cloud Platform Pricing Calculator";
    private String searchTextLink;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//input[contains(@class, 'devsite-search-field')]")
    WebElement searchButton;

    @FindBy(className = "devsite-search-results")
    WebElement searchResults;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CloudGooglePage openPage() {
        driver.navigate().to(CLOUD_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("Login page opened");
        return this;
    }

    public SearchResultPage typeInSearch(String inputData) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(inputData);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public SearchResultPage clickInSearchResult() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchField));
        return new SearchResultPage(driver);
    }


}
