package lesson10_allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureStepsTest {
    public static final String REPOSITORY = "Artifox/QaGuru";
    WebSteps webSteps = new WebSteps();

    @Test
    public void issuePresenceLambdaTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {

        });
        step("Ищем репозиторий по имени " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("В результатах поиска переходим по ссылке репозитория", () -> {
            $(linkText("Artifox/QaGuru")).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем, что нет Issues для данного репозитория", () -> {
            $(byText("There aren’t any open issues.")).shouldBe(visible);
        });
    }

    @Test
    public void issuePresenceAnnotatedStepsTest(){
        webSteps.openMainPage();
        webSteps.searchRepositoryByName(REPOSITORY);
        webSteps.openRepositoryLink(REPOSITORY);
        webSteps.openIssuesTab();
        webSteps.shouldNotSeeAnyCreatedIssues();
    }


}
