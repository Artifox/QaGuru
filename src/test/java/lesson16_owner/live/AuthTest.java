package lesson16_owner.live;

import lesson16_owner.live.config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {

    public void testAuthClasspath() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("akoptsiukh");
        assertThat(config.password()).isEqualTo("1231423412");
    }

}
