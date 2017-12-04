package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

//  copy xpath + escape //*[@id="rso"]/div[1]/div/div/div/div/h3/a
//  private static final String LOCATOR_CS = "//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a";

    private static final String LOCATOR_CS = "//*[@class = 'rc']/*[@class='r']/a[@href='http://agileszkolenia.pl/']";
    private static final String CS_PAGE_NAME = "codesprinters";
    private static final String SEARCH_BOX_LOCATION = "lst-ib";

    public WebDriver driver;

    @Before
    public void initializeBrowser() {

        // alternative if no environment variable $PATH$ is set up
        // System.setProperty("webdriver.chrome.driver", "c:\\Webdrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void canFindCSPageOnFirstGoogleResultPage() throws InterruptedException {

        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.id(SEARCH_BOX_LOCATION));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(CS_PAGE_NAME);
        searchBox.submit();

        Assert.assertTrue("CS page found", driver.findElements(By.xpath(LOCATOR_CS)).size() > 0);

        Thread.sleep(1000);

    }

    @After
    public void closeBrowser() {

        // in case driver crashes
        if(driver != null) driver.quit();

    }
}
