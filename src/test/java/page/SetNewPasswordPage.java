package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetNewPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    public SetNewPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return newPasswordField.isDisplayed()
                && webDriver.getTitle().contains("Reset Your Password")
                && webDriver.getCurrentUrl().contains("checkpoint/rp/password-reset?requestSubmissionId=");
    }
}
