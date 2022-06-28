package lesson9_files.selenide_download;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideDownloadTests {

    @Test
    public void downloadTest() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File filePath = $("#raw-url").download();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            byte[] fileContent = inputStream.readAllBytes();
            String asString = new String(fileContent, UTF_8);
            assertThat(asString).contains("This repository is the home of the next generation of JUnit");
        }
    }

    @Test
    public void uploadTest() {
        Selenide.open("https://fineuploader.com/demos.html");
        $("input[type='file']").uploadFromClasspath("files/1.txt");
        $$("div.qq-dialog-message-selector")
                .find(text(
                        "1.txt has an invalid extension. " +
                                "Valid extension(s): jpeg, jpg, gif, png."
                )).shouldBe(visible);
    }
}
