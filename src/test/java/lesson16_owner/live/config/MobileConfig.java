package lesson16_owner.live.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${device}.properties",
        "classpath:mobile.properties",
})
public interface MobileConfig extends Config {
    @Key("platform.name")
    String getPlatformName();

    @Key("device.name")
    String getDeviseName();

    @Key("platform.version")
    String getPlatformVersion();
}
