package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'search-filters-bar')]")
    private WebElement searchFiltersBar;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchFiltersBar, 5);

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchFiltersBar));
    }

    public boolean isPageLoaded() {
        return searchFiltersBar.isDisplayed()
                && webDriver.getTitle().contains("| Search | LinkedIn")
                && webDriver.getCurrentUrl().contains("/search/results");
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);
            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }


}
