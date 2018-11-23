import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("a@b.c", "");

        Assert.assertTrue(loginPage.isPageLoaded(),
                "LogIn page is not loaded.");
    }

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        HomePage homePage = loginPage.loginToHome("linkedin.tst.yanina@gmail.com", "Test123!");

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }

    @Test
    public void negativeLeadsToLoginSubmitPage() {
        LoginPage loginPage = new LoginPage(webDriver);

        LoginSubmitPage loginSubmitPage = loginPage.loginToLoginSubmit(
                "linkedin.tst.yanina@@gmail.com", "wrong");

        Assert.assertTrue(loginSubmitPage.isPageLoaded(),
                "Login Submit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.getUserEmailError(),
                "Hmm, we don't recognize that email. Please try again.",
                "userEmail Validation message is wrong.");

        Assert.assertEquals(loginSubmitPage.getUserPassError(), "",
                "userPass Validation message is wrong.");
    }
}
