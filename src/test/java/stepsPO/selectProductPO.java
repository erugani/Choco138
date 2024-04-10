package stepsPO;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class selectProductPO {

    final WebDriver driver;
    //static String userForCookie;
    private CartPage cartPage;
    private  InventoryPage inventoryPage;
    private  InventoryItemPage inventoryItemPage;
    private  HomePage homePage;

    private static BasePage basePage;


    public selectProductPO(BasePage basePage){
        this.driver = basePage.driver;

    }




    @Given("I acess SauceDemo Store PO")
    public void i_acess_sauce_demo_store() {
        driver.get("https://www.saucedemo.com");
    }
    @When("I filled user {string} and password {string} PO")
    public void i_filled_user_and_password(String user, String password) {
        homePage.logar(user, password);
    }
    @And("I click in Login PO")
    public void i_click_in_login() {
        // remover esta linha
        homePage.cliclarNoBotaoLogin();
    }
    //@Then("show page's title {string}")
    @Then("I verify the page's title {string} PO")
    public void show_page_s_title(String pageTitle) {
        assertEquals(inventoryPage.lerTituloDaPagina(), pageTitle);
    }
    @And("show cart's link PO")
    public void show_cart_s_link() {

        assertTrue(inventoryPage.imgCarrinho.isDisplayed());
    }
    @When("I click in product {string} PO")
    public void i_click_in_product(String productId) {
        inventoryPage.clicarNoTituloDoProduto(productId);
    }
    @Then("I Verify the product title {string} PO")
    public void i_verify_the_product_title(String productTitle) {
        assertEquals(inventoryItemPage.lerTituloDoProduto(), productTitle);
    }
    @And("I verify the product price {string} PO")
    public void i_verify_the_product_price(String productPrice) {
        assertEquals(inventoryItemPage.lerPrecoDoProduto(), productPrice);
    }
    @And("I click in Add to Cart PO")
    public void i_click_in_add_to_cart() {

        //driver.findElement(By.id("add-to-cart")).click();
        inventoryItemPage.clicarNoBotaoAdicionarOuRemoverNoCarrinho();

    }
    @And("I click in Cart icon PO")
    public void i_click_in_cart_icon() {

        inventoryPage.clicarNoCarrinho();
    }

    //public void i_verify_the_page_s_title(String string) {

    //}
    @And("I verify the quantity is {string} PO")
    public void i_verify_the_quantity_is(String quantity) {
        assertEquals(cartPage.lerQuantidadeDoProdutoNoCarrinho(), quantity);
    }

    @Then("I Verify the product title {string} in cart PO")
    public void i_verify_the_product_title_in_cart(String productTitle) {


        for (int i = 1; i < cartPage.contarProdutosNoCarrinho(); i++) {

           cartPage.clicarNoBotaoRemoverNoCarrinho();

        }

        assertEquals(cartPage.lerTituloProdutoNoCarrinho(), productTitle);
    }

    @Then("I verify the product price {string} in cart PO")
    public void i_verify_the_product_price_in_cart(String productPrice) {

        assertEquals(cartPage.lerPrecoProdutoNoCarrinho(), productPrice);
    }





}
