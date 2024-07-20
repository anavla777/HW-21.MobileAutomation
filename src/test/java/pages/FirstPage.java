package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class FirstPage {

    private static final SelenideElement
            forwardButtonOnFirstPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            addLanguageButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));


    @Step("Check that add language button is clickable and has correct text")
    public FirstPage checkTextOnAddLanguageButton() {
        addLanguageButton.shouldBe(visible);
        addLanguageButton.shouldBe(clickable);
        addLanguageButton.shouldHave(text("Add or edit languages"));
        return this;
    }

    @Step("Tap  Continue button")
    public void clickContinueButtonOnFirstPage() {
        forwardButtonOnFirstPage.click();
    }

    @Step("Check accessibility of Skip button")
    public FirstPage checkSkipButtonOnFirstPage() {
        skipButton.shouldBe(visible);
        skipButton.shouldBe(clickable);
        skipButton.shouldHave(text("Skip"));
        return this;
    }
}
