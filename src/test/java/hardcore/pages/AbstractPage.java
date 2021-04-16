package hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
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
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(checkboxToClick)).click();
        }


    protected void openDropDownMenu(WebElement openedDropDropMenu) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});"
                , openedDropDropMenu);
        while (openedDropDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(openedDropDropMenu))
                    .click();
        }
    }

    public void selectFromDropDown(String locatorInExpanded, String selectedValue){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(String.format(locatorInExpanded, selectedValue))))).click();
    }

    public void waitAndClickToWebElement(WebElement webElement){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void waitAndSendKeys(WebElement webElement, String keys) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(visibilityOf(webElement))
                .sendKeys(keys);
    }
    public void waitAndSwitchToFrame(WebElement frame) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
    }

}
