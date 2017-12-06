package wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WordPressPage {

    public static final String WORDPRESS_PAGE_URL = "https://autotestjava.wordpress.com/";
    private static final long TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_CLICKABLE = 30 ;

    protected WebDriver driver;

    public WordPressPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void writeInto(String text, WebElement webElement) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_CLICKABLE);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
