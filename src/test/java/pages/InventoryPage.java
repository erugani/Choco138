package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends CommonPage {

    //@FindBy(id = "item_4_title_link")
    //WebElement lnkTituloProduto;


    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    public void clicarNoTituloDoProduto(String productId){

        String idDinamico = "item_" + productId + "_title_link";
        driver.findElement(By.id(idDinamico)).click();
    }






}
