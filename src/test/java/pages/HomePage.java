package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(id = "user-name")
    WebElement txtUsuario;

    @FindBy(id = "password")
    WebElement txtSenha;

    @FindBy(id = "login-button")
    WebElement btnLogin;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logar(String user, String password){
        txtUsuario.sendKeys(user);
        txtSenha.sendKeys(password);
        //btnLogin.click();
    }

    public void cliclarNoBotaoLogin(){
        btnLogin.click();
    }



}
