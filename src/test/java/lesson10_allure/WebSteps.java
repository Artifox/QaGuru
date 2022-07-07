package lesson10_allure;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step
    public void openMainPage() {
        Selenide.open("https://github.com/");
    }

    @Step
    public void searchRepositoryByName(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step
    public void openRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step
    public void openIssuesTab() {
        $("#issues-tab").click();
        //TODO: Check that page is opened
        takeScreenShot();
    }

    @Step
    public void shouldNotSeeAnyCreatedIssues() {
        $(byText("There aren’t any open issues.")).shouldBe(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
