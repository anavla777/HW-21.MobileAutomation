package config;

import com.codeborne.selenide.Configuration;
import drivers.BrowserStackMobileDriver;
import drivers.LocalMobileDriver;

public class LocalMobileDriverReader {
    public void setLocalMobileDriverConfig() {
        String deviceHost = System.getProperty("deviceHost");
        Configuration.browserSize = null;
        if ((deviceHost == null) || deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserStackMobileDriver.class.getName();
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
    }
}
