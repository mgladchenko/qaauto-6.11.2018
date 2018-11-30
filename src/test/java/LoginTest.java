import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "Test123!" },
                { "linkedin.tst.yanina@GMAIL.COM", "Test123!" },
                { " linkedin.tst.yanina@gmail.com ", "Test123!" },
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPass) {
        LoginPage loginPage = new LoginPage(webDriver);
        HomePage homePage = loginPage.login(userEmail, userPass);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] loginSubmitData() {
        return new Object[][]{
                { "linkedin.tst.yanina@@gmail.com", "wrong", "Hmm, we don't recognize that email. Please try again.", "" },
        };
    }

    @Test(dataProvider = "loginSubmitData")
    public void negativeLeadsToLoginSubmitPage(
            String userEmail,
            String userPass,
            String emailValidationMessage,
            String passValidationMessage
    )
    {
        LoginPage loginPage = new LoginPage(webDriver);

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPass);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(),
                "Login Submit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.getUserEmailError(),
                emailValidationMessage,
                "userEmail Validation message is wrong.");

        Assert.assertEquals(loginSubmitPage.getUserPassError(),
                passValidationMessage,
                "userPass Validation message is wrong.");
    }
}
