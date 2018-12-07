package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetSubmitPage extends BasePage {

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    public RequestPasswordResetSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return resendLinkButton.isDisplayed()
                && webDriver.getTitle().contains("Please check your mail for reset password link")
                && webDriver.getCurrentUrl().contains("checkpoint/rp/request-password-reset-submit");
    }

    public SetNewPasswordPage navigateToLinkFromEmail() {

        String messageSubject = "here's the link to reset your password";
        String messageTo = "linkedin.tst.yanina@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(
                messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        return new SetNewPasswordPage(webDriver);

    }
}
