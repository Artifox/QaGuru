package lesson5_6.tests;

import com.codeborne.selenide.Configuration;
import lesson5_6.pages.RegistrationFromPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = true;
    }
}
