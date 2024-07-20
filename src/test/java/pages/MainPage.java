package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    private static final SelenideElement
            searchBar = $(id("org.wikipedia.alpha:id/search_container")),
            wikiFeed = $(id("org.wikipedia.alpha:id/feed_view"));

    @Step("Check that search bar is visible")
    public MainPage checkAccessibilityOfSearchBar() {
        searchBar.shouldBe(visible);
        return this;
    }

    @Step("Check that news feed is visible")
    public void checkVisibilityOfNewsFeed() {
        wikiFeed.shouldBe(visible);

    }

}
