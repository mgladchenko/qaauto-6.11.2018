import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello world!!!");
        //System.setProperty("webdriver.chrome.driver", "C:/chromedriver");

        WebDriver webDriver = new ChromeDriver();
        String searchTerm = "Selenium";
        webDriver.get("https://www.google.com/");

        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> resultsList = webDriver.findElements(
                By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println(resultsList.size());

        //for each WebElement 'result' in List of WebElements 'resultsList' print Text.

        for (WebElement result : resultsList) {
            String resultText = result.getText();

            if (resultText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm " + searchTerm + " found in block:\n" + resultText);
            } else {
                System.out.println("searchTerm " + searchTerm + " NOT found in block:\n" + resultText);
            }

        }


    }
}
