import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){
        super();
        this.driver = driver;
    }

    private By userNameField = By.xpath("//input[@id='user[login]']");
    private By emailField = By.xpath("//input[@id='user[email]']");
    private By passwordField = By.xpath("//input[@id='user[password]']");
    private By signUpFormButton = By.xpath("//button[@class='btn-mktg btn-primary-mktg f4 btn-block mb-3']");
    private By heading = By.xpath("//h1[@class='h000-mktg lh-condensed mb-3']");
    private By userNameError = By.xpath("//dd[@class='error']");
    private By emailError = By.xpath("//dd[contains(text(),'Email is invalid or already taken')]");
    private By passwordError = By.xpath("//p[@class='form-control-note text-white mb-4']");

    public MainPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typeEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public MainPage typePasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage clickSignUpFormButton(){
        driver.findElement(signUpFormButton).click();
        return new MainPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public boolean isUserNameErrorVisible(String message){
        return driver.findElement(userNameError).isDisplayed();
    }

    public boolean isEmailErrorVisible(String message){
        return driver.findElement(emailError).isDisplayed();
    }

    public boolean isPasswoerdErrorVisible(String message){
        return driver.findElement(passwordError).isDisplayed();
    }

    public boolean isHeadingVisible(String text){
        return driver.findElement(heading).isDisplayed();
    }
}
