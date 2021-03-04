package optional_task.i_can_win.test.i_can_win;

import io.github.bonigarcia.wdm.WebDriverManager;
import optional_task.i_can_win.page.PasteBinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverTest {
    WebDriver chromeDriver;

    private static WebDriver StartScenario(WebDriver driver) {
        new PasteBinMainPage(driver)
                .openPage()
                .inputData()
                .clickCreate();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.chromedriver().setup();
    }


    @Test(description = "I can win test scenario")
    public void scenarioTest() {
        chromeDriver = StartScenario(new ChromeDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestCompleted() {
        driverQuit(chromeDriver);
    }

    private void driverQuit(WebDriver driver) {
        driver.quit();
    }
}
