package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver webDriver;

    abstract boolean isPageLoaded();

}
