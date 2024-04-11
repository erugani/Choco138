package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Base;

import java.time.Duration;

public class Hooks {
    Base base;

    public Hooks(Base base) {
        this.base = base;
    }
    @Before
    public void before_all(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        base.driver = new ChromeDriver(options);

        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        base.driver.manage().window().maximize();
    }
    @After
    public void after_all() {

        base.driver.quit();
    }
}
