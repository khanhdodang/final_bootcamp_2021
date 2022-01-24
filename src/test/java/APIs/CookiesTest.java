package APIs;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        Cookie cookie = new Cookie("bar", "foo");
        driver.manage().addCookie(cookie);   //Create and add the cookie
        driver.manage().getCookies();   // Return The List of all Cookies
        System.out.println(driver.manage().getCookies());
        driver.manage().getCookieNamed("bar");  //Return specific cookie according to name
        System.out.println(driver.manage().getCookieNamed("bar"));
        driver.manage().deleteCookie(cookie);  // Delete specific cookie
        driver.manage().deleteCookieNamed("bar"); // Delete specific cookie according Name
        driver.manage().deleteAllCookies();  // Delete all cookies
        System.out.println(driver.manage().getCookies());


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
