package first_steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("http://google.com");
        Thread.sleep(2000);
        driverChrome.quit();


        System.setProperty("webdriver.edge.driver","D:\\webdriver\\msedgedriver.exe");



//        WebDriver driverEdge = new EdgeDriver();
//        driverEdge.get("http://google.com");
//        Thread.sleep(2000);
//        driverEdge.quit();

//        WebDriver driverFox = new FirefoxDriver();
//        driverFox.get("http://google.com");
//        Thread.sleep(2000);
//        driverFox.quit();



    }
}
