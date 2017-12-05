package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.domain.User;

import static wordpress.pages.WordNotePage.LOCATOR_AUTHOR;
import static wordpress.pages.WordNotePage.LOCATOR_COMMENT;
import static wordpress.pages.WordNotePage.LOCATOR_EMAIL;

public class WordNoteComment {
    private WebDriver driver;
    private WebElement webElement;

    WordNoteComment(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
    }

    public void AddReply(User user) {
        {

            WebElement replyButton = webElement.findElement(By.className("comment-reply-link"));
            replyButton.click();

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_COMMENT));
            WebElement commentBox = driver.findElement(LOCATOR_COMMENT);
            commentBox.click();
            commentBox.clear();
            commentBox.sendKeys(user.getComment());

            WebElement email = driver.findElement(LOCATOR_EMAIL);
            email.clear();
            email.sendKeys(user.getUserEmail());

            WebElement author = driver.findElement(LOCATOR_AUTHOR);
            author.clear();
            author.sendKeys(user.getUserName());
//        website.sendKeys(user_website);
            author.submit();


        }
    }

    public boolean checkComment(String comment, String userName) {
        return driver.findElement(By.cssSelector(".comments-area")) != null;
    }
}
