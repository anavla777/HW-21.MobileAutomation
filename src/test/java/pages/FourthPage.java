package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FourthPage {

    private static final SelenideElement
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            doneButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Check accessibility Get Started button on last page")
    public void checkAccessibilityOfDoneButtonOnLastPage() {
        doneButton.shouldBe(visible);
        doneButton.shouldBe(clickable);
        doneButton.shouldHave(text("Get started"));
    }

    @Step("Check Text on PrimaryText label")
    public FourthPage checkPrimaryTextOnLastPage() {
        primaryText.shouldHave(text("Data & Privacy"));
        return this;
    }
}
