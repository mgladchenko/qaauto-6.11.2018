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
        webDriver.get("https://www.google.com/");

        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> resultsList = webDriver.findElements(
                By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println(resultsList.size());




    }
}
