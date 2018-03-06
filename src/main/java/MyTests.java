import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class MyTests {

    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        String userEmail = "webinar.test@gmail.com";
        String userPasswd = "Xcg7299bnSmMuRLp9ITw";

        loginPage.open();
        loginPage.typeEmail(userEmail);
        loginPage.typePasswd(userPasswd);
        loginPage.clickSubmit();
        dashboardPage.getLinks();
        dashboardPage.clickAvatarIcon();
        dashboardPage.leavePage();

        driver.quit();

    }

    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver",
                new File(MyTests.class.getResource("/chromedriver.exe").getFile()).getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

}
