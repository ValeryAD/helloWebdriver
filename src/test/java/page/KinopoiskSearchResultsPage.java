package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KinopoiskSearchResultsPage extends AbstractPage {

    private String term;

    @FindBy(xpath = "//div[@class='search_results']/div[contains(@class,'element')]")
    private List<WebElement> searchResults;


    public KinopoiskSearchResultsPage(WebDriver driver, String term){
        super(driver);
        this.term = term;
    }

    public String getSearchResultsHeaderText(){
        return new WebDriverWait(driver, 15)
            .until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@class='search_results'][1]/p"))).getText();
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("This method is not supposed to be used with search page." +
                " In case you need to use it you may extend this class and override the method.");
    }

    public int countSearchResults(){
        //List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath("//div[@class='search_results']/p[text()='Скорее всего, вы ищете:']/.."));
        //return resultsNumberWithSearchTerm.size();
        return searchResults.size();
    }
}
