package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.MyWebDriver;

public class LoginPage extends BasePage {
    //WebDriver object
    private WebDriver driver;

    //WebDriverWait object
    private WebDriverWait wait = null;

    //Log object
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    //Page elements
    @FindBy(xpath = "//a[contains(@class, 'gmail-nav__nav-link__sign-in')]")
    private WebElement SIGN_IN_LINK;

    @FindBy(id = "identifierId")
    private WebElement EMAIL_INPUT;

    @FindBy(id = "identifierNext")
    private WebElement NEXT_BUTTON;

    @FindBy(name = "password")
    private WebElement PASSWORD_INPUT;

    @FindBy(id = "passwordNext")
    private WebElement PASSWORD_NEXT_BUTTON;

    @FindBy(xpath = "//div[contains(@class, 'GQ8Pzc')]")
    private WebElement LOGIN_ERROR_MSG;

    //Constructor
    public LoginPage() {
        PageFactory.initElements(driver = MyWebDriver.getChromeDriverInstance(), this );
        wait = MyWebDriver.getWebDriverWaitInstance();
    }

    //Action methods
    public void goToLoginPage(String url) {
        LOGGER.info("Going to the Login page...");
        super.goToURL(url);
    }

    public void clickSignInLink() {
        LOGGER.info("Login page: Clicking on \"SignIn\" link...");
        try {
            super.findVisibleElementWithTimeout(SIGN_IN_LINK, 5).click();
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void typeAccount(String account) {
        LOGGER.info("Login page: Typing user account name...");
        try {
            super.findVisibleElementWithTimeout(EMAIL_INPUT, 5).clear();
            super.findVisibleElementWithTimeout(EMAIL_INPUT, 5).sendKeys(account);
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void clickNextButton() {
        LOGGER.info("Login page: Clicking on \"Next\" button...");
        try {
            super.findVisibleElementWithTimeout(NEXT_BUTTON, 5).click();
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void typePassword(String password) {
        LOGGER.info("Login page: Typing user password...");
        try {
            super.findVisibleElementWithTimeout(PASSWORD_INPUT, 5).clear();
            super.findVisibleElementWithTimeout(PASSWORD_INPUT, 5).sendKeys(password);
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void clickPasswordNextButton() {
        LOGGER.info("Login page: Clicking on \"Next\" button...");
        try {
            super.findVisibleElementWithTimeout(PASSWORD_NEXT_BUTTON, 5).click();
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    //Get methods
    public String getAccountErrorMessage() {
        LOGGER.info("Login page: Getting account error message...");
        String msg = "";
        try {
            msg = driver.findElement(By.xpath("//div[contains(@class, 'GQ8Pzc')]")).getText();
            LOGGER.info("Login page: Actual error message = " + "\"" + msg + "\"");
        }catch (StaleElementReferenceException e){
            LOGGER.error(e.getMessage());
        }
        return msg;
    }

    public String getPasswordErrorMessage() {
        LOGGER.info("Login page: Getting password error message...");
        String msg = "";
        try {
            msg = driver.findElement(By.xpath("//div[contains(@class, 'GQ8Pzc')]")).getText();
            LOGGER.info("Login page: Actual error message = " + "\"" + msg + "\"");
        }catch (StaleElementReferenceException e){
            LOGGER.error(e.getMessage());
        }
        return msg;
    }

    //Checking methods
    public boolean checkLoginPageTitle(String title) {
        if(super.getPageTitle().contains(title)) {
            LOGGER.info("Login page: Login page title is correct.");
            return true;
        }else{
            LOGGER.info("Login page: Login page title is incorrect.");
            return false;
        }
    }
}
