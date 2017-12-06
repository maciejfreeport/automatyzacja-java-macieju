package wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WordPressPage {

    public static final String WORDPRESS_PAGE_URL = "https://autotestjava.wordpress.com/";

    protected WebDriver driver;

    public WordPressPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void writeInto(String text, WebElement webElement) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }
}
