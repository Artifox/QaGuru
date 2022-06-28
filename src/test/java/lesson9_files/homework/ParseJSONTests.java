package lesson9_files.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson9_files.homework.pojo.Resource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseJSONTests {

    ClassLoader classLoader = ParseJSONTests.class.getClassLoader();

    @Test
    public void parseJsonWithJackson() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream("test_data/test-json.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = objectMapper.readValue(inputStream, Resource.class);
        String name = resource.getData().get(0).getName();
        assertThat(name).isEqualTo("cerulean");
    }
}
