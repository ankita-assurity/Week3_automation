package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public ResultsPage searchforGold(String searchString) {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys(searchString);
        queryBox.sendKeys(Keys.RETURN);
        return new ResultsPage(webDriver);
    }
}
