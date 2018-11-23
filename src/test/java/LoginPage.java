import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginSubmitPage loginToLoginSubmit(String userEmail, String userPass) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPass);
        signInButton.click();
        return new LoginSubmitPage(webDriver);
    }

    public HomePage loginToHome(String userEmail, String userPass) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPass);
        signInButton.click();
        return new HomePage(webDriver);
    }

    public LoginPage login(String userEmail, String userPass) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPass);
        signInButton.click();
        return new LoginPage(webDriver);
    }


    public boolean isPageLoaded() {
       return signInButton.isDisplayed()
               && webDriver.getTitle().equals("LinkedIn: Log In or Sign Up")
               && webDriver.getCurrentUrl().equals("https://www.linkedin.com/");
    }

}
