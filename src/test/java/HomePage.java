import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver webDriver;

    private WebElement welcomeMessage;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements() {
        welcomeMessage = webDriver.findElement(
                By.xpath("//a[@data-control-name='identity_welcome_message']"));
    }

    public boolean isPageLoaded() {
        return welcomeMessage.isDisplayed()
                && webDriver.getTitle().contains("LinkedIn")
                && webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/");
    }

}
