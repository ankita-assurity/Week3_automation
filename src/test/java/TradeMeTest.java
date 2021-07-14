import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ResultsPage;

public class TradeMeTest {

    private WebDriver webDriver;
    private HomePage homePage;
    private ResultsPage resultsPage;

    @BeforeAll
    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void setupBrowser() {
        chromesetup();
        homePage = new HomePage(webDriver);

    }

    private void chromesetup() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.tmsandbox.co.nz/");
    }

    @AfterEach
    private void teardownBrowser() {
        webDriver.quit();
    }


    @Test
    public void searchgold1() throws Exception {
        homePage.searchforGold();
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
        queryBox.sendKeys("gold");
        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"generalSearch\"]/div[2]/button")); //FIND AN ELEMENT
        button.click();

        Thread.sleep(5000);
    }

    @Test
    public void goldlisting() throws Exception {
        resultsPage = homePage.searchforGold();
        Thread.sleep(5000);

        //Print out the number of listings
        String listings = resultsPage.getTotalCount();

        //Print out the current price of the top item shown
        String price = resultsPage.getTotalCount();

        //Click on the List View button
        System.out.println(("Price = " + price));
        WebElement button = webDriver.findElement(By.xpath("//*[@id=\"ListingViewBar_galleryListToggle\"]/ul/li[1]")); //FIND AN ELEMENT
        button.click();
        Thread.sleep(5000);


//Print out the titles of the top 10 items

//String x = getTotalCount("//*[@id=\"mainContent\"]/div[8]/div[1]/a/div");
//List<String> names = new ArrayList<>();
//
//        for(int i = 1;i<=10; i++ ){
//           System.out.println(i);
//            String nameselector = "div{data-ga-identifier["+i+"]div.title}";
//            System.out.println(("names = " + nameselector));
//
//        }


    }

    @Test
    public void footertask() throws Exception {
        homePage.searchforGold();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("site-footer")));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-of-page\"]/div[3]")));

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
