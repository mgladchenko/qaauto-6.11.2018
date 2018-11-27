import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@data-control-name='identity_welcome_message']")
    private WebElement welcomeMessage;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    public boolean isPageLoaded() {
        return welcomeMessage.isDisplayed()
                && webDriver.getTitle().contains("LinkedIn")
                && webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/");
    }

}
