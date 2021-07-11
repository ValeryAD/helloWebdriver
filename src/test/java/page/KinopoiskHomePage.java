package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class KinopoiskHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.kinopoisk.ru/";

    @FindBy(name = "kp_query")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='moFfZn4KKpRIplidX2WPE _3pjeTIo9jXyo5E4IHn9YaQ']")
    private WebElement searchButton;


    public KinopoiskHomePage(WebDriver driver){
        super(driver);
    }

    public KinopoiskHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public KinopoiskSearchResultsPage searchForTerms(String term){
        searchInput.sendKeys(term);
        searchButton.click();
        return new KinopoiskSearchResultsPage(driver, term);
    }
}
