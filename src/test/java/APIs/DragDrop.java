package APIs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragDrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement element_a = driver.findElement(By.id("column-a"));
        WebElement element_b = driver.findElement(By.id("column-b"));

        Actions act = new Actions(driver);
        act.dragAndDrop(element_a, element_b).build().perform();

        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));
        int x = b.getLocation().x;
        int y = b.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(a)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(a)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(b)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();


        driver.close();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
