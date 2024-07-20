package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ThirdPage {
    private static final SelenideElement
            continueButtonOnSecondPage = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            primaryText = $(id("org.wikipedia.alpha:id/primaryTextView"));


    @Step("Check Text on PrimaryText label")
    public ThirdPage checkPrimaryTextonThirdPage() {
        primaryText.shouldHave(text("Reading lists with sync"));
        return this;
    }

    @Step("Tap Continue on third page")
    public void clickOnContinueButtonOnThirdPage() {
        continueButtonOnSecondPage.click();
    }
}
