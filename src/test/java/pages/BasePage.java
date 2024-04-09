package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(css = "span.title")
    WebElement lblTituloPagina;

    @FindBy (id = "shopping_cart_container")
    WebElement imgCarrinho;

    @FindBy(css = "button.btn btn_primary btn_small btn_inventory")
    WebElement btnAdicionarOuRemoverNoCarrinho;

    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String lerTituloAba(){
        return driver.getTitle();

    }
    public String lerTituloDaPagina(){

        return lblTituloPagina.getText();
    }
    public void clicarNoCarrinho() {
        imgCarrinho.click();
    }

    public String lerTextoDoBotaoAdicionarRemoverDoCarrinho(){
        return btnAdicionarOuRemoverNoCarrinho.getText();
    }

    public void clicarNoBotaoAdicionarOuRemoverNoCarrinho(){

        btnAdicionarOuRemoverNoCarrinho.click();
    }

}
