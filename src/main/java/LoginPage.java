import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwdField = By.id("passwd");
    private By submitButton = By.name("submitLogin");
    private String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    public void open() {
        driver.get(url);
    }

    public LoginPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage typePasswd(String passwd){
        driver.findElement(passwdField).sendKeys(passwd);
        return this;
    }

    public void clickSubmit() {
        driver.findElement(submitButton).submit();
    }
}
