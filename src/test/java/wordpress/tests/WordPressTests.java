package wordpress.tests;

import org.junit.Assert;
import org.junit.Test;
import wordpress.domain.User;
import wordpress.pages.MainPage;
import wordpress.pages.NotePage;
import wordpress.pages.WordPressPage;

public class WordPressTests extends BaseTest {

    private MainPage getMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        return mainPage;
    }

    private NotePage getNotePage() {
        NotePage notePage = new NotePage(driver);
        notePage.openNotePage(1);
        return notePage;
    }

    @Test
    public void verifyMainPageIsOpen() {

        MainPage mainPage = getMainPage();
        Assert.assertTrue("WordPress Main Page is open", mainPage.matchesUrl(WordPressPage.WORDPRESS_PAGE_URL));

    }

    @Test
    public void verifyNoteIsOpen() {
        MainPage mainPage = getMainPage();

        NotePage notePage = getNotePage();

        Assert.assertTrue("Note is open and section comment is available", notePage.checkComments());
    }


    @Test
    public void addingCommentIsPossible() {

        MainPage mainPage = getMainPage();
        NotePage notePage = getNotePage();
        User user = new User().RandomCommentEntry();

        notePage.AddComment(user.getComment(), user.getUserEmail(), user.getUserName());

        Assert.assertTrue("Comment has been added", notePage.checkComment(user.getComment(), user.getUserName()));
    }


}
