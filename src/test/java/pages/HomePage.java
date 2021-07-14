package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ResultsPage searchforGold() {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        return new ResultsPage(webDriver);
    }
}
