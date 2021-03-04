package optional_task.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinMainPage extends AbstractPage {
    private static final String PAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement textArea;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement timeExpirationDropDown;

    @FindBy(xpath = "//*[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement tenMinutesExpiration;

    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement titleField;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    public PasteBinMainPage(WebDriver driver) {
        super(driver);
    }

    public PasteBinMainPage openPage() {
        driver.manage().window().maximize();
        driver.get(PAGE_URL);
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXCompleted());
        return this;
    }


    public PasteBinMainPage inputData() {
        textArea.sendKeys("Hello from WebDriver");
        timeExpirationDropDown.click();
        if (tenMinutesExpiration.isDisplayed()) tenMinutesExpiration.click();
        titleField.sendKeys("helloweb");
        return this;
    }


    public PasteBinMainPage clickCreate() {
        if (createNewPasteButton.isDisplayed()) {
            createNewPasteButton.click();
        }
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXCompleted());
        return this;
    }

}
