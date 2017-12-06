package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WordPressAdminPage extends WordPressPage {
    public WordPressAdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {

        List<WebElement> adminBar = driver.findElements(By.id("wpadminbar"));
        return adminBar.size() == 1;
    }
}
