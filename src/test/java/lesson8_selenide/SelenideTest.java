package lesson8_selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lesson5_6.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideTest extends BaseTest {

    @Test
    @DisplayName("Check JUnit5 at the WIki page")
    public void selenideTest() {
        //- Откройте страницу Selenide в Github
        Selenide.open("https://github.com/selenide/selenide");

        //- Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");

        //- Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        SelenideElement softAssertonText = $$("li.Box-row").filterBy(Condition.text("SoftAssertions")).first().shouldBe(Condition.visible);

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        softAssertonText.click();
        $("#wiki-body").$$("h4").filterBy(Condition.text("JUnit5")).first().shouldBe(Condition.visible);
    }
}
