package pageobjects.tests;

import org.junit.Assert;
import org.junit.Test;
import pageobjects.domain.CodeSprinters;
import pageobjects.pages.GoogleMainPage;
import pageobjects.pages.GoogleResultPage;

public class GoogleSearchTests extends BaseTest {

    @Test
    public void OpenBrowser() {

        //arrange
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.open();

        //act
        GoogleResultPage resultPage = mainPage.searchFor(CodeSprinters.PAGE_NAME);

        //assert
        Assert.assertTrue("CS page found", resultPage.countResultWithUrl(CodeSprinters.PAGE_URL) > 0);
    }
}
