package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    public void openBrowser(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        //open the URL
        driver.get(baseUrl);
        //maximize the URl
        driver.manage().window().maximize();
        //implicit time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closebrowser() {
        driver.close();
    }
}
