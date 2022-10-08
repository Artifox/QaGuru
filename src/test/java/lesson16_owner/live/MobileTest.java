package lesson16_owner.live;

import lesson16_owner.live.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {

    @Test
    public void testMobile() {
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviseName()).isEqualTo("iPhone 13");
        assertThat(config.getPlatformName()).isEqualTo("iOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
    }

    @Test
    public void testMobileWithSystemOverriding() {
        System.setProperty("device.name", "android");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviseName()).isEqualTo("iPhone 13");
        assertThat(config.getPlatformName()).isEqualTo("iOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
    }

    @Test
    public void testMobileWithAndroid() {
        System.setProperty("device", "iphone-13");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviseName()).isEqualTo("iPhone 13");
        assertThat(config.getPlatformName()).isEqualTo("iOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
    }

    @Test
    public void testMobileWithIPhone() {
        System.setProperty("device", "google-pixel");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviseName()).isEqualTo("Google Pixel 5x");
        assertThat(config.getPlatformName()).isEqualTo("Android");
        assertThat(config.getPlatformVersion()).isEqualTo("24");
    }

}
