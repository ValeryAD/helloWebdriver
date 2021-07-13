package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.KinopoiskHomePage;

import java.util.List;

public class WebDriverSeleniumHQTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsNotEmpty() {

        int expectedSearchResultsNumber = new KinopoiskHomePage(driver)
                .openPage()
                .searchForTerms("it")
                .countSearchResults();

        Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty");
    }

    @AfterMethod(alwaysRun = true)
    private void browserTearDown() {
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
