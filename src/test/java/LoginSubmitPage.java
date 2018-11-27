import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage extends BasePage {

    private WebElement loginForm;
    private WebElement userEmailError;
    private WebElement userPassError;


    public LoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements() {
        loginForm = webDriver.findElement(By.xpath("//form[@class='login__form']"));
        userEmailError = webDriver.findElement(By.xpath("//div[@id='error-for-username']"));
        userPassError = webDriver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && webDriver.getTitle().equals("Sign In to LinkedIn")
                && webDriver.getCurrentUrl().contains("uas/login-submit");
    }

    public String getUserEmailError() {
        return userEmailError.getText();
    }

    public String getUserPassError() {
        return userPassError.getText();
    }

}
