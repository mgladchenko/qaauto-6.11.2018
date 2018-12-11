package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

public abstract class BasePage {
    protected static GMailService gMailService;

    protected WebDriver webDriver;

    protected void waitUntilElementIsVisible(WebElement elementToWaitFor) {
        waitUntilElementIsVisible(elementToWaitFor, 5);
    }

    protected void waitUntilElementIsVisible(WebElement elementToWaitFor, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }

    public abstract boolean isPageLoaded();

}
