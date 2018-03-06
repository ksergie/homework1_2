import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By avatarIcon = By.className("employee_avatar_small");
    private By logoutLink = By.id("header_logout");
    private By menuItems = By.xpath("//li[contains(@class, 'maintab')]/a");
    List<WebElement> menuLinks = new ArrayList<WebElement>();
    List<String> hrefs = new ArrayList<String>();

    public void getLinks(){
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItems));
        List<WebElement> menuLinks = driver.findElements(menuItems);
        for (WebElement link: menuLinks) {
            hrefs.add(link.getAttribute("href"));
        }
        for (String href : hrefs) {
            driver.get(href);
            getTitleAndCheck();
        }
    }

    public DashboardPage clickAvatarIcon(){
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon)).click();
        return this;
    }

    public void leavePage() {
        driver.findElement(logoutLink).click();
    }

    public void getTitleAndCheck() {
        String title = driver.getTitle();
        System.out.println(title);
        driver.navigate().refresh();
        if (title.equals(driver.getTitle())) {
            System.out.println("The titles are equal after refresh the page");
        } else {
            System.out.println("The titles are NOT equal after refresh the page");
        }
    }
}
