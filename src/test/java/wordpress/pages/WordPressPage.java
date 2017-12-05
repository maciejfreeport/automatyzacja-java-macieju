package wordpress.pages;

import org.openqa.selenium.WebDriver;

public abstract class WordPressPage {

    public static final String WORDPRESS_PAGE_URL = "https://autotestjava.wordpress.com/";

    protected WebDriver driver;

    public WordPressPage(WebDriver driver) {
        this.driver = driver;
    }
}
