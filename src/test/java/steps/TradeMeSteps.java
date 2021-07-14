package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ResultsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeMeSteps {

    private WebDriver webDriver;
    private HomePage homePage;
    private ResultsPage resultsPage;

    @Given("I am conducting a TradeMe search")
    public void i_am_conducting_a_trade_me_search() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.get("https://www.tmsandbox.co.nz/");
         homePage = new HomePage(webDriver);

    }


    @When("I search for {string}")
    public void i_search_for(String string) {

       resultsPage = homePage.searchforGold("gold");

    }

    @Then("I see {int} results")
    public void i_see_results(Integer int1) {

        assertEquals(int1,resultsPage.getTotalCount());

    }

    @After
    public void cleanUp(){
        webDriver.quit();
    }


}