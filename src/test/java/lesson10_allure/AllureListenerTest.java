package lesson10_allure;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class AllureListenerTest {

    @Test
    public void issuePresenceTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Artifox/QaGuru");
        $(".header-search-input").submit();

        $(linkText("Artifox/QaGuru")).click();
        $("#issues-tab").click();
        $(byText("There aren’t any open issues.")).shouldBe(visible);
    }
}
