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


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @Test(description = "I can win hardcore.test scenario")
    public void scenarioTest2() {
        new PasteBinMainPage(this.chromeDriver)
                .openPage()
                .typeTitle("helloweb")
                .inputData("Hello from WebDriver")
                .checkExpiration()
                .clickCreate();

    }

    @AfterMethod(alwaysRun = true)
    public void afterTestCompleted() {
        chromeDriver.quit();
        chromeDriver = null;
    }


}
