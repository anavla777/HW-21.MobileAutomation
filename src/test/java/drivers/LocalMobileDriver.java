package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.LocalMobileDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalMobileDriver implements WebDriverProvider {
    static LocalMobileDriverConfig localMobileDriverConfig = ConfigFactory.create(
            LocalMobileDriverConfig.class,
            System.getProperties()
    );

    public static URL getAppiumServerUrl() {
        try {
            return new URI(localMobileDriverConfig.appiumUrl()).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(localMobileDriverConfig.automationName())
                .setPlatformName(localMobileDriverConfig.platformName())
                .setDeviceName(localMobileDriverConfig.deviceName())
                .setFullReset(localMobileDriverConfig.appFullReset())
                .setApp(getAppPath())
                .setAppPackage(localMobileDriverConfig.appPackage())
                .setAppActivity(localMobileDriverConfig.appActivity())
                .setLanguage(localMobileDriverConfig.appLanguage())
                .setLocale(localMobileDriverConfig.appLocale());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appVersion = localMobileDriverConfig.appVersion();
        String appUrl = localMobileDriverConfig.appUrl() + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URI(appUrl).toURL().openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return app.getAbsolutePath();
    }
}
