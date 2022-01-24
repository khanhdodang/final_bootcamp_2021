package APIs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        sleep(4);
        select.selectByValue("1");
        sleep(4);
        select.selectByIndex(1);
        sleep(4);
        driver.close();
    }

    public static void sleep (int seconds) {
        try {
            Thread.sleep(seconds * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
