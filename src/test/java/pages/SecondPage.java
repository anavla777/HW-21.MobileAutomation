package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SecondPage {
    private static final SelenideElement
            continueButtonOnSecondPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));


    @Step("Check Text on PrimaryText label")
    public SecondPage checkPrimaryTextonSecondPage() {
        primaryText.shouldHave(text("New ways to explore"));
        return this;
    }

    @Step("Tap Continue on Second page")
    public void clickOnContinueButtonOnSecondPage() {
        continueButtonOnSecondPage.click();
    }

    @Step("Check accessibility of Skip button on second page")
    public SecondPage checkSkipButtonOnSecondPage() {
        skipButton.shouldBe(visible);
        skipButton.shouldBe(clickable);
        skipButton.shouldHave(text("Skip"));
        return this;
    }
}
