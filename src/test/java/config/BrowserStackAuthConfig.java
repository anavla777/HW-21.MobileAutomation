package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:BrowserStackAuth.properties"
})
public interface BrowserStackAuthConfig extends Config {
    @Key("browserStackUser")
    String bsLogin();

    @Key("browserStackPassword")
    String bsPassword();
}
