import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {
    public WebDriver driver;
    @Given("I enter the amazon website")
    public void i_enter_the_amazon_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
    }

    @And("I enter {string} in search field")
    public void i_enter_book_in_search_field(String bookname) {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        search.sendKeys(bookname);

    }
    @When("I click enter")
    public void i_click_enter() {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        button.click();
    }
    @And("I select the third book from the result")
    public void i_select_the_third_book_from_the_result() {
        WebElement clickresult = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a"));
        clickresult.click();
    }
    @Then("I display the details of the book")
    public void i_display_the_details_of_the_book() {
        WebElement bookTitle = driver.findElement(By.xpath("//*[@id=\"productTitle\"]"));
        System.out.println("Book Title is: " + bookTitle.getText());
        WebElement bookAuthor = driver.findElement(By.xpath("//*[@id=\"bylineInfo\"]/span/a"));
        System.out.println("The author of the book is: " + bookAuthor.getText());
        WebElement bookPrice = driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[3]/span[2]/span[2]"));
        System.out.println("Price of the book is: " + bookPrice.getText());
    }
}
