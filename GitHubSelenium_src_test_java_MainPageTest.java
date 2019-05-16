import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage page;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/Pavlik/Desktop/GitHubSelenium/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/");
    }

    @Test
    public void getHeadingText(){
        page = new MainPage(driver);
        page.getHeadingText();
        Assert.assertTrue(page.isHeadingVisible("Build better together"));
    }

    @Test
    public void typeInvalidUserName(){
        page = new MainPage(driver);
        page.typeUserName("1");
        Assert.assertTrue(page.isUserNameErrorVisible("Username is already taken"));
    }

    @Test
    public void typeInvalidEmail(){
        page = new MainPage(driver);
        page.typeEmailField("1");
        Assert.assertTrue(page.isEmailErrorVisible("Email is invalid or already taken"));
    }

    @Test
    public void typeInvalidPassword(){
        page = new MainPage(driver);
        page.typePasswordField("1");
        Assert.assertTrue(page.isPasswoerdErrorVisible("Make sure it's "));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}