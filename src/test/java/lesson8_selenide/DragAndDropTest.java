package lesson8_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lesson5_6.tests.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropTest extends BaseTest {

    SelenideElement aBox = $("#column-a");
    SelenideElement bBox = $("#column-b");

    @Test
    public void dragAndDropTest() {

        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");

        //- Перенесите прямоугольник А на место В
        $("#columns").$$("div.column").first().shouldHave(Condition.exactText("A"));
        $("#column-a").dragAndDropTo("#column-b");

        // - Проверьте, что прямоугольники действительно поменялись
        $("#columns").$$("div.column").first().shouldHave(Condition.exactText("B"));

    }
}
