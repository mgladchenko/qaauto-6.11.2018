package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetPage extends BasePage {

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;


    public RequestPasswordResetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return findAccountButton.isDisplayed()
                && webDriver.getTitle().contains("Reset Password | LinkedIn")
                && webDriver.getCurrentUrl().contains("uas/request-password-reset");
    }

    public RequestPasswordResetSubmitPage findAccount(String userEmail) {
        gMailService = new GMailService();
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        findAccountButton.click();
        return new RequestPasswordResetSubmitPage(webDriver);
    }
}
