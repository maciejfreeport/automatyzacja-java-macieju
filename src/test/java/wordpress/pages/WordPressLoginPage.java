package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressLoginPage extends WordPressPage {

    public static final String WORDPRESS_LOGIN_ADDRESS_PAGE = WORDPRESS_PAGE_URL + "wp-login.php";

    public WordPressLoginPage(WebDriver driver) {
        super(driver);
    }

    public WordPressAdminPage login(String userName, String password) {

        driver.get(WORDPRESS_LOGIN_ADDRESS_PAGE);
        WebElement userNameInputBox = driver.findElement(By.id("usernameOrEmail"));
        writeInto(userName, userNameInputBox);
        userNameInputBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        WebElement passwordBox = driver.findElement(By.id("password"));
        writeInto(password, passwordBox);
        userNameInputBox.submit();

        return new WordPressAdminPage(driver);
    }

}
