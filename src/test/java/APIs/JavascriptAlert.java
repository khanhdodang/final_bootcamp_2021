package APIs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlert {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement button_js_alerts = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        button_js_alerts.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        sleep(4);
        alert.accept();

        WebElement button_js_confirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        button_js_confirm.click();

        driver.switchTo().alert();
        System.out.println(alert.getText());
        sleep(4);
        alert.dismiss();

        WebElement button_js_prompt= driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        button_js_prompt.click();
        driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Hi Oanh");
        sleep(4);
        alert.accept();
        sleep(4);

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
