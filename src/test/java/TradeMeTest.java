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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TradeMeTest {

    private WebDriver webDriver;

    @BeforeAll
    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.tmsandbox.co.nz/");
    }

    @AfterEach
    private void teardownBrowser() {
        webDriver.quit();
    }


    @Test
    public void searchgold1() throws Exception {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);


    }


    @Test
    public void searchgold2() throws Exception {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        queryBox.submit();
        Thread.sleep(5000);
    }

    @Test
    public void searchgold3() throws Exception {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        // WebElement queryBox = webDriver.findElement(By.xpath("//*[@id=\"generalSearch\"]/div[2]/button")); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"generalSearch\"]/div[2]/button")); //FIND AN ELEMENT
        button.click();

        Thread.sleep(5000);
    }

    @Test
    public void goldlisting() throws Exception {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);


        //Print out the number of listings
        String listings = webDriver.findElement(By.xpath("//*[@id=\"totalCount\"]")).getText();


//WebElement listings = webDriver.findElement(By.id("totalCount"));
        System.out.println(("listing = " + listings));


        //Print out the current price of the top item shown
        String price = webDriver.findElement(By.xpath("//*[@id=\"SuperGridGallery_BucketList_ClassifiedPrice_listingClassifiedPriceAmountPoa\"]")).getText();
        //Click on the List View button
        System.out.println(("Price = " + price));
        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"ListingViewBar_galleryListToggle\"]/ul/li[1]")); //FIND AN ELEMENT
        button.click();
        Thread.sleep(5000);


//Print out the titles of the top 10 items

String x = webDriver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[8]/div[1]/a/div")).getText();
List<String> names = new ArrayList<>();

        for(int i = 1;i<=10; i++ ){
           System.out.println(i);
            String nameselector = "div{data-ga-identifier["+i+"]div.title}";
            System.out.println(("names = " + nameselector));

        }


    }

    @Test
    public void footertask() throws Exception {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-footer")));
        System.out.println("!!!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-of-page\"]/div[3]")));

    }
    @Test
    public void sortexercise() throws Exception {
        WebElement queryBox = webDriver.findElement(By.name(("searchString"))); //FIND AN ELEMENT
        queryBox.sendKeys("gold");
        queryBox.submit();
        Thread.sleep(5000);
        Select select = new Select(webDriver.findElement(By.id("listingTitleBarSelect")));
        select.selectByVisibleText("Lowest Buy Now");
        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"ListingViewBar_galleryListToggle\"]/ul/li[1]")); //FIND AN ELEMENT
        button.click();
        Thread.sleep(5000);


    }



}
