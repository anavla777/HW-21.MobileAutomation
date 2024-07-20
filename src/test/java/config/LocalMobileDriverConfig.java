package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
        "file:~/${deviceHost}.properties"
})

public interface LocalMobileDriverConfig extends Config  {

    String deviceName();

    @DefaultValue("http://localhost:4723/wd/hub")
    String appiumUrl();

}
