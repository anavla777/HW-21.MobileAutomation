package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackAuthConfig;
import config.BrowserStackDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;


public class BrowserStackMobileDriver implements WebDriverProvider {


    static final BrowserStackAuthConfig authConfig = ConfigFactory.create(BrowserStackAuthConfig.class, System.getProperties());
    private static final BrowserStackDriverConfig config = ConfigFactory.create(BrowserStackDriverConfig.class);


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.browserstackPlatform())
                .setDeviceName(config.browserstackDevice())
                .setFullReset(false)
                .setApp(config.browserstackApp());

        try {
            return new AndroidDriver(new URI("https://" + authConfig.bsLogin() + ":" + authConfig.bsPassword()
                    + "@" + config.browserstackUrl()).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
