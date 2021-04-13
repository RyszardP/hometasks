package hardcore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    protected void clickToCheckBox(WebElement checkboxToClick) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , checkboxToClick);
        if (checkboxToClick.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(checkboxToClick))
                    .click();
        }
    }

    protected void openDropDownMenu(WebElement openedDropDropMenu) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , openedDropDropMenu);
        while (openedDropDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(openedDropDropMenu))
                    .click();
        }
    }

    protected void elementWaitAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , element);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
