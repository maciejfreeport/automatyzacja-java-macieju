package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage extends GooglePage {

    private static final By LOCATOR_SEARCH_BOX = By.id("lst-ib");

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(GOOGLE_ADDRESS);
    }

    public GoogleResultPage searchFor(String pageName) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(LOCATOR_SEARCH_BOX));

        WebElement searchBox = driver.findElement(LOCATOR_SEARCH_BOX);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(pageName);
        searchBox.submit();

        return new GoogleResultPage(driver);
    }
}
