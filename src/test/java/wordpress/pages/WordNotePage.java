package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordNotePage extends WordPressPage {

    public static final By LOCATOR_COMMENT = By.id("comment");
    public static final By LOCATOR_EMAIL = By.id("email");
    public static final By LOCATOR_AUTHOR = By.id("author");
    public static final By LOCATOR_WEBSITE = By.id("url");

    public WordNotePage(WebDriver driver) {
        super(driver);
    }

    public void openNotePage(int noteNumber) {

        driver.findElement(By.xpath("//article[" +noteNumber + "]//h1[@class='entry-title']/a")).click();

    }

    public boolean checkComment() {
        return driver.findElement(By.cssSelector(".comments-area")) != null;
    }

    public void AddComment(String comment, String user_email, String user_name) {

        WebElement commentBox = driver.findElement(LOCATOR_COMMENT);
        commentBox.click();
        commentBox.sendKeys(comment);

        WebElement email = driver.findElement(LOCATOR_EMAIL);
        email.sendKeys(user_email);

        WebElement author = driver.findElement(LOCATOR_AUTHOR);
        author.sendKeys(user_name);
//        website.sendKeys(user_website);
        author.submit();

    }

    public boolean checkComment(String comment, String name) {

        List<WebElement> comments = driver.findElements(By.className("comment-body"));
        Stream<WebElement> results = comments.stream();
        long count = results
                .filter(result -> result.findElement(By.tagName("cite")).getText().equals(name))
                .filter(result -> result.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment))
                .count();
        if(count == 1) {
            return true;
        }else return false;
    }

    public WordNoteComment findComment(String comment, String name) {

        List<WebElement> webElements = driver.findElements(By.className("comment-body")).stream()
                .filter(result -> result.findElement(By.tagName("cite")).getText().equals(name))
                .filter(result -> result.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment))
                .collect(Collectors.toList());

        if (webElements.size() > 1) {
            throw new RuntimeException("something descriptive");
        }

        return new WordNoteComment(driver, webElements.get(0));
    }
}
