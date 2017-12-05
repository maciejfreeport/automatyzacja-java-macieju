package pageobjects.pages;

import org.openqa.selenium.WebDriver;

public abstract class GooglePage {

    protected static final String GOOGLE_ADDRESS = "https://www.google.com";
    protected WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }
}
