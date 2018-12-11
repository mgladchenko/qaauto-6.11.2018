package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@data-control-name='identity_welcome_message']")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='nav-search-typeahead']//input")
    private WebElement searchField;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    public boolean isPageLoaded() {
        return welcomeMessage.isDisplayed()
                && webDriver.getTitle().contains("LinkedIn")
                && webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/");
    }

    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);

        return new SearchResultsPage(webDriver);
    }
}
