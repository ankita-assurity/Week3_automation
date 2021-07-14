import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    private WebDriver webDriver;
@BeforeAll
    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
    }
    @AfterEach
    private void teardownBrowser() {
        webDriver.quit();
    }

    @Test
    public void checkTitle(){


        String title = webDriver.getTitle();
        assertEquals("Google",title);
        teardownBrowser();

    }


    @Test
    public void testCheese() throws Exception{
        WebElement queryBox = webDriver.findElement(By.name(("q"))); //FIND AN ELEMENT
        queryBox.sendKeys("cheese");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
    }
}
