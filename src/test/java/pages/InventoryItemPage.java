package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends CommonPage {

    @FindBy(css = "div.inventory_details_name.large_size")
    WebElement lblTituloProduto;

    @FindBy(css = "div.inventory_details_price")
    WebElement lblPrecoProduto;

    public InventoryItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String lerTituloDoProduto(){
        return lblTituloProduto.getText();
    }

    public String lerPrecoDoProduto(){
        return lblPrecoProduto.getText();
    }



}
