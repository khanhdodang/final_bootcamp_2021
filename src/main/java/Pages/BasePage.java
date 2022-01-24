package Pages;

import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setupDriver(String browser) {
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        maximizeBrowser();
        driver.manage().timeouts().pageLoadTimeout(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Maximize browser
     */
    public void maximizeBrowser () {
        Reporter.log("Maximize browser");
        driver.manage().window().maximize();
    }

    /**
     * Find element
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
        Reporter.log("Find element by locator" + by.toString());
        return driver.findElement(by);
    }

    /**
     * Find and wait Element CLickable
     * @param by
     * @param seconds
     * @return
     */
    public WebElement waitElementClickable(By by, int seconds) {
        Reporter.log("Wait element by locator" + by.toString() + "during " + seconds + "seconds");
        return new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(by));
    }

    /** Fullscreen method */
    public void fullscreen () {
        Reporter.log("Maximize browser");
        driver.manage().window().fullscreen();
    }

    /** Refresh browser */
    public void refresh() {
        Reporter.log("Refresh browser");
        driver.navigate().refresh();
    }

    /** Back browser */
    public void back() {
        Reporter.log("Back browser");
        driver.navigate().back();
    }

    /** Forward browser */
    public void forward() {
        Reporter.log("Forward browser");
        driver.navigate().forward();
    }

    /**
     * Navigate to the URL
     * @param url
     */
    public void get (String url) {
        Reporter.log("Navigate to " + url);
        driver.get(url);
    }

    /**
     * Get title
     * @return
     */
    public String getTitle () {
        Reporter.log("Get current title");
        return driver.getTitle();
    }

    /**
     * Send keys
     * @param by
     * @param value
     */
    public void sendKeys (By by, String value) {
        Reporter.log("Set the text on the element by locator" + by.toString() + "with the value" + value);
        findElement(by).sendKeys(value);
    }

    /**
     * Click
     * @param by
     */
    public void click (By by) {
        Reporter.log("Click on the element by locator" + by.toString());
        findElement(by).click();
    }

    /**
     * Get text
     * @param by
     * @return
     */
    public String getText (By by) {
        Reporter.log("Get text on the element by locator" + by.toString());
        return findElement(by).getText();
    }

    /**
     * Get Current URL
     * @return
     */
    public String getURL () {
        return driver.getCurrentUrl();
    }

    /**
     * Clear text on element
     * @param by
     */
    public void clear(By by) {
        Reporter.log("Clear text on the element by locator" + by.toString());
        findElement(by).clear();
    }

    /**
     * Check if Element is Enable
     * @param by
     * @return
     */
    public boolean isEnable (By by) {
        Reporter.log("Get enable property on the element by locator" + by.toString());
        return findElement(by).isEnabled();
    }

    /**
     * Check if Element is Displayed
     * @param by
     * @return
     */
    public boolean isDisplayed (By by) {
        Reporter.log("Get Displayed property on the element by locator" + by.toString());
        return findElement(by).isDisplayed();
    }

    /**
     * Get TagName of an element
     * @param by
     * @return
     */
    public String getTagName (By by) {
        Reporter.log("Get TagName on the element by locator" + by.toString());
        return findElement(by).getTagName();
    }

    /**
     * Get Rectangle
     * @param by
     * @return
     */
    public Rectangle getRect (By by) {
        Reporter.log("Get Rectangle on the element by locator" + by.toString());
        return findElement(by).getRect();
    }

    /**
     * Get CSS value
     * @param by
     * @return
     */
    public String getCSSValue (By by, String value) {
        Reporter.log("Get CSS Value on the element by locator" + by.toString());
        return findElement(by).getCssValue(value);
    }

}
