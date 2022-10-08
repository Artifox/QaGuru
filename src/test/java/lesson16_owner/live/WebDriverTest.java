package lesson16_owner.live;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson16_owner.live.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
    WebDriver driver;

    @BeforeEach
    private void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGitHub() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        /*WebDriver driver = getDriver();*/

        //driver.get("https://github.com");
        String title = driver.getTitle();
        Assertions.assertEquals("GitHub: Where the world builds software · GitHub", title);
        //driver.quit();
    }

    @Test
    public void testGitHub2() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
       /* WebDriver driver = getDriver();*/

        //driver.get("https://github.com");
        String title = driver.getTitle();
        Assertions.assertEquals("GitHub: Where the world builds software · GitHub", title);
        //driver.quit();
    }

    @Test
    public void testGitHub3() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
       /* WebDriver driver = getDriver();*/

        //driver.get("https://github.com");
        String title = driver.getTitle();
        Assertions.assertEquals("GitHub: Where the world builds software · GitHub", title);
        //driver.quit();
    }

    /*private WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://github.com");
        return driver;
    }*/

    @AfterEach
    private void stopDriver() {
        driver.quit();
    }
}
