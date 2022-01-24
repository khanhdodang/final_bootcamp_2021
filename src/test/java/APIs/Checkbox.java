package APIs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement element1 = driver.findElement(By.xpath("//input[@type = 'checkbox'][1]"));
        WebElement element2 = driver.findElement(By.xpath("//input[@type = 'checkbox'][2]"));

        System.out.println("Before click----");
        System.out.println(element1.isSelected());
        System.out.println(element2.isSelected());

        element1.click();
        element2.click();

        System.out.println("After click----");
        System.out.println(element1.isSelected());
        System.out.println(element2.isSelected());
        driver.close();
    }
}
