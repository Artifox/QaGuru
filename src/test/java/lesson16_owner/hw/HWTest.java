package lesson16_owner.hw;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class HWTest {
    WebDriver driver;

    @BeforeEach
    private void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    @Tag("lesson16")
    public void testPayPal() {
        String title = driver.getTitle();
        Assertions.assertEquals("Digital Wallets, Money Management, and More | PayPal US | PayPal US", title);
    }


    @AfterEach
    private void stopDriver() {
        if (driver != null){
            driver.quit();
        }
    }
}
