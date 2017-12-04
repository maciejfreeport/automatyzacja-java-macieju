package pageobjects.tests;

import org.junit.Assert;
import org.junit.Test;
import pageobjects.domain.CodeSprinters;
import pageobjects.pages.GoogleMainPage;
import pageobjects.pages.GoogleResultPage;

public class GoogleSearchTests extends BaseTest {

    private GoogleResultPage searchOnGoogle(String pageName) {
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.open();

        return mainPage.searchFor(pageName);
    }

    @Test
    public void verifyGoogleFindsCodeSprintersPage() {

        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);

        //assert
        Assert.assertTrue("'" + CodeSprinters.PAGE_NAME + "' page found", resultPage
                .countResultWithUrl(CodeSprinters.PAGE_URL) > 0);
    }

    @Test
    public void verifyGoogleShowsNoCodeSprintersOnSecondPage() {

        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
        GoogleResultPage secondResultPage = resultPage.displayNextPage();

        Assert.assertTrue("Pages with URL starting with '" + CodeSprinters.PAGE_URL + "' not found",
                secondResultPage.countResultsWithUrlMatching(CodeSprinters.PAGE_URL) == 0);


    }
}
