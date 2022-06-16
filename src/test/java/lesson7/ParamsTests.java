package lesson7;

import lesson5_6.tests.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParamsTests extends BaseTest {

    @BeforeAll
    public void beforeAll() {
        System.out.println("BeforeAll annotation");
    }

    @AfterAll
    public void afterAll(){
        System.out.println("AfterAll annotation");
    }

    @Test
    @DisplayName("rezka.ag test scenario")
    public void mandalorianRezkaTest() {
        open("https://rezka.ag/");
        $("#search-field").setValue("Мандалорец").pressEnter();
        $(".b-content__inline_items").shouldHave(text("Мандалорец")).shouldBe(visible);
    }


    @ValueSource(strings = {"Мандалорец", "Книга Бобы Фетта"})
    @ParameterizedTest(name = "When I look for {0} I see {0} among search results")
    public void generalRezkaTest(String testData) {
        open("https://rezka.ag/");
        $("#search-field").setValue(testData).pressEnter();
        $(".b-content__inline_items").shouldHave(text(testData)).shouldBe(visible);
    }

    @CsvFileSource(resources = "/test_data/test.csv")
    @ParameterizedTest(name = "When I look for {0} I see {0} among search results")
    public void csvFileRezkaTest(String filmName, String production) {
        open("https://rezka.ag/");
        $("#search-field").setValue(filmName).pressEnter();
        $(".b-content__inline_items").shouldHave(text(production)).shouldBe(visible);
    }

    @CsvSource(value = {
            "Мандалорец, 2019 - ..., США, Боевики",
            "Книга Бобы Фетта, 2021 - ..., США, Фантастика"
    })
    @ParameterizedTest(name = "When I look for {0} I see {0} among search results")
    public void csvSourceRezkaTest(String filmName, String production) {
        open("https://rezka.ag/");
        $("#search-field").setValue(filmName).pressEnter();
        $(".b-content__inline_items").shouldHave(text(production)).shouldBe(visible);
    }

    static Stream<Arguments> methodSourceRezkaTestDataProvider() {
        return Stream.of(
                Arguments.of("Мандалорец", List.of("2019 - ..., США, Боевики", "2 сезон, 8 серия")),
                Arguments.of("Книга Бобы Фетта", List.of("2021 - ..., США, Фантастика", "1 сезон, 7 серия"))
        );
    }

    @MethodSource(value = "methodSourceRezkaTestDataProvider")
    @ParameterizedTest(name = "When I look for {0} I see {0} among search results")
    public void methodSourceRezkaTest(String filmName, List<String> expectedResults) {
        open("https://rezka.ag/");
        $("#search-field").setValue(filmName).pressEnter();
        for (String elem : expectedResults) {
            $(".b-content__inline_items").shouldHave(text(elem));
        }
    }
}
