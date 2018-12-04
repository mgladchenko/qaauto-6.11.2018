package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultsPage;

import java.util.List;

public class SearchTest extends BaseTest{

    /**
     * Preconditions:
     * - Open browser
     * - Navigate to linkedin.com
     * - Login with valid credentials
     *
     * Scenario:
     * - Verify Home page is loaded.
     * - Enter "HR" into searchField.
     * - Press Return key on keyboard.
     * - Verify SearchResults page is loaded.
     * - Verify results list contains 10 items.
     * - Verify each item contains searchTerm.
     *
     * Postcondition:
     * - Close browser.
     *
     */
    @Test
    public void basicSearchTest() {
        HomePage homePage = loginPage.login("linkedin.tst.yanina@gmail.com", "Test123!");
        String searchTerm = "HR";

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(),
                "SearchResults page is not loaded.");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10,
                "Search results count is wrong.");

        List<String> searchResultsList = searchResultsPage.getSearchResults();

        for (String searchResult : searchResultsList){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+searchTerm+" not found in: \n"+searchResult);

        }





    }

}
