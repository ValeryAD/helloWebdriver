import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebDriverSeleniumHQTestWithoutPageObjectPattern {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test (description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsNotEmpty() {

        driver.get("https://www.kinopoisk.ru/");

        WebElement searchInput = findElementLocatedBy(By.name("kp_query"));
        searchInput.sendKeys("it");

        List<WebElement> searchButton = findElementsLocatedBy(By.xpath("//button[@class='moFfZn4KKpRIplidX2WPE _3pjeTIo9jXyo5E4IHn9YaQ']"));
        searchButton.get(0).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result list was exceeded");

        List<WebElement> searchResults = wait.until(new Function<WebDriver, List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver webDriver) {
                return webDriver.findElements(By.xpath("//div[@class='search_results']/p[text()='Скорее всего, вы ищете:']/.."));
            }
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(searchResults.size() > 0, "Search results are empty");
    }

    @AfterMethod(alwaysRun = true)
    private void browserTearDown(){
        driver.quit();
        driver = null;
    }

    private WebElement findElementLocatedBy(By by) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> findElementsLocatedBy(By by) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }


}
