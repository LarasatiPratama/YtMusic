package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Search {
    private WebDriver driver;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("Open web url {string}")
    public void openWebUrl(String url) {
        driver.get(url);
    }

    @When("User click search button")
    public void user_click_search_button() {
        driver.findElement(By.className("ytmusic-search-box")).click();
    }

    @And("User input {string}")
    public void userInput(String keywords) {
        driver.findElement(By.cssSelector(".search-box > #input")).sendKeys(keywords);
    }

    @And("User press Enter")
    public void user_press_enter() {
        driver.findElement(By.cssSelector(".search-box > #input")).sendKeys(Keys.ENTER);
    }

    @Then("Showing top result\\(s) on result page")
    public void showing_top_result_s_on_result_page() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//div[@id='contents']/ytmusic-shelf-renderer[1]/div[1]/h2"));
        Assert.assertEquals(element.getText(), "Top result");
    }

    @Then("Showing No result")
    public void showingNoRelust() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"items\"]/ytmusic-message-renderer/yt-formatted-string[1]"));
        Assert.assertEquals(element.getText(), "No results found");
    }

    @When("User click on the result")
    public void userClickOnTheResult() throws InterruptedException {
        Thread.sleep(3000);
        WebElement play = driver.findElement(By.xpath("/html/body/ytmusic-app/ytmusic-app-layout/div[3]/ytmusic-search-page/ytmusic-tabbed-search-results-renderer/div[2]/ytmusic-section-list-renderer/div[2]/ytmusic-shelf-renderer[1]/div[3]/ytmusic-responsive-list-item-renderer/div[1]/ytmusic-item-thumbnail-overlay-renderer/div/ytmusic-play-button-renderer/div/yt-icon"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", play);
    }

    @Then("the song is playing")
    public void theSongIsPlaying() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}