package wordpress.tests;

import org.junit.Assert;
import org.junit.Test;
import wordpress.domain.User;
import wordpress.pages.WordNoteComment;
import wordpress.pages.WordPressMainPage;
import wordpress.pages.WordNotePage;
import wordpress.pages.WordPressPage;

public class WordPressTests extends BaseTest {

    private WordPressMainPage getMainPage() {
        WordPressMainPage wordPressMainPage = new WordPressMainPage(driver);
        wordPressMainPage.open();
        return wordPressMainPage;
    }

    private WordNotePage getNotePage() {
        WordNotePage wordNotePage = new WordNotePage(driver);
        wordNotePage.openNotePage(1);
        return wordNotePage;
    }

    @Test
    public void verifyMainPageIsOpen() {

        WordPressMainPage wordPressMainPage = getMainPage();
        Assert.assertTrue("WordPress Main Page is open", wordPressMainPage.matchesUrl(WordPressPage.WORDPRESS_PAGE_URL));

    }

    @Test
    public void verifyNoteIsOpen() {

        getMainPage();
        WordNotePage wordNotePage = getNotePage();

        Assert.assertTrue("Note is open and section comment is available", wordNotePage.checkComment());
    }


    @Test
    public void addingCommentIsPossible() {

        getMainPage();
        WordNotePage wordNotePage = getNotePage();
        User user = new User().RandomCommentEntry();

        wordNotePage.AddComment(user.getComment(), user.getUserEmail(), user.getUserName());

        Assert.assertTrue("Comment has been added", wordNotePage.checkComment(user.getComment(), user.getUserName()));
    }

    @Test
    public void addingReplyToCreatedComment() {

        getMainPage();
        WordNotePage wordNotePage = getNotePage();
        User user = new User().RandomCommentEntry();

        wordNotePage.AddComment(user.getComment(), user.getUserEmail(), user.getUserName());
        WordNoteComment createdComment = wordNotePage.findComment(user.getComment(), user.getUserName());

        user = new User().RandomCommentEntry();
        createdComment.AddReply(user);

        Assert.assertTrue("Reply has been added", createdComment.checkComment(user.getComment(), user.getUserName()));
    }

}
