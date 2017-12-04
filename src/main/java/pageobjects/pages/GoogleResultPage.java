package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class GoogleResultPage extends GooglePage {

    private static final String LOCATOR_SINGLE_RESULT = ".rc > .r > a";

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }


    public int countResultWithUrl(String pageUrl) {

        List<WebElement> results = driver.findElements(By.cssSelector(LOCATOR_SINGLE_RESULT));
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream
                .filter(result -> result
                .getAttribute("href").equals(pageUrl)).count();
    }

//      alternative
//    public int countResultWithUrl2(String pageUrl) {
//
//        return (int) driver.findElements(By.cssSelector(".rc > .r > a")).stream().
//                filter(result -> result.getAttribute("hrsef").equals(pageUrl)).count();
//    }
}
