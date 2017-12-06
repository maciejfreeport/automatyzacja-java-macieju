package wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordPressLoginPage extends WordPressPage {

    private static final String WORDPRESS_LOGIN_ADDRESS_PAGE = WORDPRESS_PAGE_URL + "wp-login.php";

    // alternative for driver.FindElement, saves code
    private @FindBy(id = "usernameOrEmail") WebElement userNameInputBox;
    private @FindBy(id = "password") WebElement passwordBox;

    public WordPressLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WordPressAdminPage login(String userName, String password) {

        driver.get(WORDPRESS_LOGIN_ADDRESS_PAGE);
       // WebElement userNameInputBox = driver.findElement(By.id("usernameOrEmail"));
        writeInto(userName, userNameInputBox);
        userNameInputBox.submit();

//       WebDriverWait wait = new WebDriverWait(driver, 30);
//       wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        waitUntilElementIsClickable(passwordBox);

       // WebElement passwordBox = driver.findElement(By.id("password"));
        writeInto(password, passwordBox);
        userNameInputBox.submit();

        return new WordPressAdminPage(driver);
    }

}
