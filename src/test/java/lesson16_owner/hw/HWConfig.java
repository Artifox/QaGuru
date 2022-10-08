package lesson16_owner.hw;


import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:${host}.properties"
})
public interface HWConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://www.paypal.com/us/home")
    String getBaseUrl();

    @Key("browser.version")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browser.name")
    @DefaultValue("FIREFOX")
    Browser getBrowser();

    @Key("remote.url")
    URL getRemoteUrl();
}
