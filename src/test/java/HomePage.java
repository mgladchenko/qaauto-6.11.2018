import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver webDriver;

    WebElement welcomeMessage;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        welcomeMessage = webDriver.findElement(
                By.xpath("//a[@data-control-name='identity_welcome_message']"));
    }

}
