import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        loginPage.login("linkedin.tst.yanina@gmail.com", "Test123!");

        HomePage homePage = new HomePage(webDriver);

        //Verify that page title is "LinkedIn: Log In or Sign Up"

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Home page title is wrong.");
        Assert.assertTrue(homePage.welcomeMessage.isDisplayed(),
                "Welcome message is not displayed is not displayed.");
    }

    @Test
    public void negativeLeadsToLoginSubmitPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("linkedin.tst.yanina@@gmail.com", "wrong");

        WebElement loginForm = webDriver.findElement(By.xpath("//form[@class='login__form']"));
        Assert.assertTrue(loginForm.isDisplayed(), "Login Submit page is not loaded.");

        WebElement userEmailError = webDriver.findElement(By.xpath("//div[@id='error-for-username']"));
        Assert.assertEquals(userEmailError.getText(), "Hmm, we don't recognize that email. Please try again.",
                "userEmail Validation message is wrong.");

        WebElement userPassError = webDriver.findElement(By.xpath("//div[@id='error-for-password']"));
        Assert.assertEquals(userPassError.getText(), "",
                "userPass Validation message is wrong.");





    }
}
