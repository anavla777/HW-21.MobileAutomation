package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FirstPage;
import pages.LastPage;
import pages.SecondPage;
import pages.ThirdPage;

@DisplayName("Wikipedia tests")
@Tag("mobile")
public class WikipediaTests extends TestBase {
    @DisplayName("Wikipedia app - Successful onboarding completion")
    @Test
    void onboardingTest() {

        FirstPage firstPage = new FirstPage();
        SecondPage secondPage = new SecondPage();
        ThirdPage thirdPage = new ThirdPage();
        LastPage fourthPage = new LastPage();

        firstPage.checkTextOnAddLanguageButton()
                .checkSkipButtonOnFirstPage()
                .clickContinueButtonOnFirstPage();

        secondPage.checkPrimaryTextonSecondPage()
                .checkSkipButtonOnSecondPage()
                .clickOnContinueButtonOnSecondPage();

        thirdPage.checkPrimaryTextonThirdPage()
                .clickOnContinueButtonOnThirdPage();

        fourthPage.checkPrimaryTextOnLastPage()
                .checkAccessibilityOfDoneButtonOnLastPage();
    }
}
