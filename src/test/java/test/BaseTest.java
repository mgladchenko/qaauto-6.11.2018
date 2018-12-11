package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

public class BaseTest {
    protected WebDriver webDriver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");
        loginPage = new LoginPage(webDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        webDriver.quit();
    }
}
