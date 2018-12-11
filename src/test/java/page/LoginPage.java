package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * PageObject class for LoginPage.
 */
public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    /**
     * Constructor of LoginPage class.
     * @param webDriver - webDriver instance from Test.
     */
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to log in with specific credentials.
     * @param userEmail - String with userEmail.
     * @param userPass - String with userPass.
     * @param <T> - generic type of returned PageObject.
     * @return Either HomePage/LoginSubmitPage/LoginPage page object.
     */
    public <T> T login(String userEmail, String userPass) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (webDriver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(webDriver);
        }
        if (webDriver.getCurrentUrl().contains("/login-submit")) {
            return (T) new LoginSubmitPage(webDriver);
        }
        else {
            return (T) new LoginPage(webDriver);
        }
    }

    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isPageLoaded() {
       return signInButton.isDisplayed()
               && webDriver.getTitle().equals("LinkedIn: Log In or Sign Up")
               && webDriver.getCurrentUrl().equals("https://www.linkedin.com/");
    }

    /**
     * Method that click on 'ForgotPassword' link.
     * @return RequestPasswordResetPage object.
     */
    public RequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return new RequestPasswordResetPage(webDriver);
    }
}
