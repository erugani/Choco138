package stepsPO;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.HomePage;

import java.time.Duration;

public class Hooks {
    BasePage basePage;

    public Hooks(BasePage basePage) {
        this.basePage = basePage;
    }
    @BeforeClass
    public void before_all(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        basePage.driver = new ChromeDriver(options);

        basePage.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        basePage.driver.manage().window().maximize();
    }
    @AfterClass
    public void after_all() {

        basePage.driver.quit();
    }
}
