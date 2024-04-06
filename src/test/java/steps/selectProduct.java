package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class selectProduct {

    static WebDriver driver;
    //static String userForCookie;
    @BeforeAll
    public static void before_all(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize();
    }
    @AfterAll
    public static void after_all() throws InterruptedException {
        //System.out.println(driver.manage().getCookies());
        //driver.manage().deleteCookieNamed("session-username=" + userForCookie);
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.btn.btn_secondary.btn_small.cart_button")).click();
        //Thread.sleep(3000);
        driver.quit();
    }

    @Given("I acess SauceDemo Store")
    public void i_acess_sauce_demo_store() {
        driver.get("https://www.saucedemo.com");
    }
    @When("I filled user {string} and password {string}")
    public void i_filled_user_and_password(String user, String password) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);

        //userForCookie = user;

    }
    @And("I click in Login")
    public void i_click_in_login() {
        driver.findElement(By.id("login-button")).click();
    }
    //@Then("show page's title {string}")
    @Then("I verify the page's title {string}")
    public void show_page_s_title(String pageTitle) {
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), pageTitle);
    }
    @And("show cart's link")
    public void show_cart_s_link() {
        assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
    }
    @When("I click in product {string}")
    public void i_click_in_product(String productId) {
        driver.findElement(By.id("item_"+productId+"_title_link")).click();
    }
    @Then("I Verify the product title {string}")
    public void i_verify_the_product_title(String productTitle) {
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(), productTitle);
    }
    @And("I verify the product price {string}")
    public void i_verify_the_product_price(String productPrice) {
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(), productPrice);
    }
    @And("I click in Add to Cart")
    public void i_click_in_add_to_cart() {

        //driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory")).click();

    }
    @And("I click in Cart icon")
    public void i_click_in_cart_icon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    //public void i_verify_the_page_s_title(String string) {

    //}
    @And("I verify the quantity is {string}")
    public void i_verify_the_quantity_is(String quantity) {
        assertEquals(driver.findElement(By.cssSelector("div.cart_quantity")).getText(), quantity);
    }

    @Then("I Verify the product title {string} in cart")
    public void i_verify_the_product_title_in_cart(String productTitle) {
        List<WebElement> lista = driver.findElements(By.cssSelector("div.inventory_item_name"));

        for (int i = 1; i < lista.size(); i++) {

            driver.findElement(By.cssSelector("button.btn.btn_secondary.btn_small.cart_button")).click();

        }

        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), productTitle);
    }

    @Then("I verify the product price {string} in cart")
    public void i_verify_the_product_price_in_cart(String productPrice) {

        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_price")).getText(), productPrice);
    }





}
