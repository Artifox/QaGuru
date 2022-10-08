package lesson16_owner.live.config;

import java.util.Objects;

public class WebDriverConfigOld {

    public String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");
        if (Objects.isNull(baseUrl)){
            baseUrl = "https://github.com";
        }
        return baseUrl;
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        if (Objects.isNull(browser)){
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
    }
}
