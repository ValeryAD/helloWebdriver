package first_steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverApiGeneralTimeouts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS); //период финализации загрузки страницы
        driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);//время работы асинхронного скрипта на страницы
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS); // таймаут ожидания появления веб элементов на странице при запуске методов findElement(), findElements();

        driver.get("https://nnmclub.to/");
        WebElement searchInput = driver.findElement(By.name("nm"));
        searchInput.sendKeys("It");

        WebElement searchBtn = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/form/input[3]"));
        searchBtn.click();

        TimeUnit.SECONDS.sleep(5);
        driver.quit();

        //driver.findElement() - возвращает первый найденный элемент
        //                      никогда не возвращает null
        //                      выбрасывает Exception in case of nothing is found

        //driver.findElements - возвращает список найденных элементов
        //                      collection may be empty
        //                      No exception in case of nothing is found

    }
}
