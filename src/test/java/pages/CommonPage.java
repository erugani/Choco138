package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage{

    public WebDriver driver;

    @FindBy(css = "span.title")
    WebElement lblTituloPagina;

    @FindBy (id = "shopping_cart_container")
    public WebElement imgCarrinho;

    @FindBy(css = "button.btn.btn_primary.btn_small.btn_inventory")
    WebElement btnAdicionarNoCarrinho;


    public CommonPage(WebDriver driver) {
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
        return btnAdicionarNoCarrinho.getText();
    }

    public void clicarNoBotaoAdicionarOuRemoverNoCarrinho(){

        btnAdicionarNoCarrinho.click();
    }

}
