package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
        "file:~/${deviceHost}.properties"
})

public interface LocalMobileDriverConfig extends Config {

    String automationName();

    String deviceName();

    String platformName();

    String appPackage();

    String appActivity();

    String appVersion();

    String appLanguage();

    String appLocale();

    Boolean appFullReset();

    String appUrl();

    @DefaultValue("http://localhost:4723/wd/hub")
    String appiumUrl();

}
