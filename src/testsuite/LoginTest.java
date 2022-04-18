package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredential() {
        // Enter the user name
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        // enter the password
        WebElement passwrod = driver.findElement(By.name("password"));
        passwrod.sendKeys("secret_sauce");
        // click on login
        WebElement loginlink = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginlink.click();

        WebElement actualproducts = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualResult = actualproducts.getText();
        String expectedResult = "PRODUCTS";

        Assert.assertEquals("logged in and navigate", actualResult, expectedResult);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter the user name
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        // Enter the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        // click on login
        WebElement loginlink = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginlink.click();

        int actualCountedItems = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        int expectedresult = 6;
        Assert.assertEquals("count number of items",actualCountedItems,expectedresult);
    }
@After
    public void tearDown() { closebrowser();}
}
