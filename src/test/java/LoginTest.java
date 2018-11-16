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

        //Verify that page title is "LinkedIn: Log In or Sign Up"
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up",
                "Login page title is wrong.");
        Assert.assertTrue(loginPage.signInButton.isDisplayed(), "SignIn button is not displayed.");
    }

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("linkedin.tst.yanina@gmail.com", "Test123!");

        //Verify that page title is "LinkedIn: Log In or Sign Up"
        WebElement welcomeMessage = webDriver.findElement(
                By.xpath("//a[@data-control-name='identity_welcome_message']"));

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Home page title is wrong.");
        Assert.assertTrue(welcomeMessage.isDisplayed(),
                "Welcome message is not displayed is not displayed.");


    }
}
