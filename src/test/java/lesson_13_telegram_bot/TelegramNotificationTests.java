package lesson_13_telegram_bot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("lesson13")
public class TelegramNotificationTests {

    @Test
    public void test1(){
        Assertions.assertThat(2 ==2).isTrue();
    }

    @Test
    public void test2(){
        Assertions.assertThat(false).isFalse();
    }
}
