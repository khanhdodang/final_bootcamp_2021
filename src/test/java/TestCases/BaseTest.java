package TestCases;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver;
    BasePage basePage;


    @BeforeSuite
    public void SetUp(String browserName) {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver(browserName);
    }

    @AfterSuite
    public void TearDown() {
        driver.quit();
    }
}
