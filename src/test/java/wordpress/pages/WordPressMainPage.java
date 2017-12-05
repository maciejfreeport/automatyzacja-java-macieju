package wordpress.pages;

import org.openqa.selenium.WebDriver;

public class WordPressMainPage extends WordPressPage {

    public WordPressMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(WORDPRESS_PAGE_URL);
    }

    public boolean matchesUrl(String pageUrl) {
        return pageUrl.equals(driver.getCurrentUrl());
    }

}
