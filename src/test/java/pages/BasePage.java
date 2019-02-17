package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.MyWebDriver;

import java.util.function.Function;

public class BasePage {
    //WebDriver object
    private WebDriver driver = null;

    //WebDriverWait object
    private WebDriverWait wait = null;

    //Constructor
    public BasePage() {
        PageFactory.initElements(driver = MyWebDriver.getChromeDriverInstance(), this );
        wait = MyWebDriver.getWebDriverWaitInstance();
    }

    //Navigation methods
    public void goToURL(String url) {
        driver.get(url);
    }

    //Basic element searchers
    public WebElement findPresentElementWithTimeout(WebElement element, int timeOutInSeconds) {
        return (wait = new WebDriverWait(driver, timeOutInSeconds)).until((Function<? super WebDriver, WebElement>) ExpectedConditions.presenceOfElementLocated((By) element));
    }

    public WebElement findVisibleElementWithTimeout(WebElement element, int timeOutInSeconds) {
        return (wait = new WebDriverWait(driver, timeOutInSeconds)).until((Function<? super WebDriver, WebElement>) ExpectedConditions.visibilityOf(element));
    }

    //Get page title method
    public String getPageTitle() {
        return driver.getTitle();
    }
}
