package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.MyWebDriver;

import java.util.List;

public class InboxPage extends BasePage {
    //WebDriver object
    private WebDriver driver;

    //WebDriverWait object
    private WebDriverWait wait = null;

    //Log object
    private static final Logger LOGGER = LogManager.getLogger(InboxPage.class);

    //JavascriptExecutor object
    private JavascriptExecutor exec = null;

    //Page elements
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement COMPOSE_BUTTON;

    @FindBy(xpath = "//textarea[contains(@class, 'vO')]")
    private WebElement RECIPIENT_TEXTAREA;

    @FindBy(xpath= "//input[contains(@name, 'subjectbox')]")
    private WebElement SUBJECT_INPUT;

    @FindBy(xpath = "//div[contains(@class, 'Am Al editable LW-avf')]")
    private WebElement MESSAGE_FIELD;

    @FindBy(xpath = "//div[contains(@class, 'T-I J-J5-Ji aoO T-I-atl L3')]")
    private WebElement SEND_BUTTON;

    @FindBy(xpath = "//span[contains(@class, 'bAq')]")
    private WebElement CONFIRMATION_POPUP;

    //Constructor
    public InboxPage() {
        PageFactory.initElements(driver = MyWebDriver.getChromeDriverInstance(), this );
        wait = MyWebDriver.getWebDriverWaitInstance();
    }

    //Action methods
    public void clickOnComposeButton() {
        LOGGER.info("Inbox page: Clicking on \"Compose\" button...");
        try {
              super.findVisibleElementWithTimeout(COMPOSE_BUTTON, 5).click();
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void typeRecipientEmail(String email) {
        LOGGER.info("Inbox page: Typing a recipient Email address...");
        try {
            super.findVisibleElementWithTimeout(RECIPIENT_TEXTAREA, 5).clear();
            super.findVisibleElementWithTimeout(RECIPIENT_TEXTAREA, 5).sendKeys(email);
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void typeSubject(String subject) {
        LOGGER.info("Inbox page: Typing a subject...");
        try {
            super.findVisibleElementWithTimeout(SUBJECT_INPUT, 5).clear();
            super.findVisibleElementWithTimeout(SUBJECT_INPUT, 5).sendKeys(subject);
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void typeMessage(String message) {
        LOGGER.info("Inbox page: Typing a subject...");
        try {
            super.findVisibleElementWithTimeout(MESSAGE_FIELD, 5).clear();
            super.findVisibleElementWithTimeout(MESSAGE_FIELD, 5).sendKeys(message);
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void clickOnSendButton() {
        LOGGER.info("Inbox page: Clicking on \"Send\" button...");
        try {
            super.findVisibleElementWithTimeout(SEND_BUTTON, 5).click();
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void openInboxMessage(String subject_text) {
        LOGGER.info("Inbox page: Opening the message...");
        try {
            List<WebElement> inboxEmails = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='zA zE']"))));
            for(WebElement email : inboxEmails) {
                if (email.isDisplayed() && email.getText().contains(subject_text)) {
                    email.click();
                }
            }
        }catch (StaleElementReferenceException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void clickRemoveButton() {
        LOGGER.info("Inbox page: Clicking on \"Remove\" button...");
        try {
            driver.findElement(By.xpath("//*[@id=':4']/div[2]/div[1]/div/div[2]/div[3]")).click();
        }catch (TimeoutException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void clicOnAccountLogoLink() {
        LOGGER.info("Inbox page: Clicking on Account logo link...");
        try {
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/header/div[2]/div[3]/div/div[2]/div/a/span")).click();
        }catch (TimeoutException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void clicOnLogoutLink() {
        LOGGER.info("Inbox page: Clicking on \"Logout\" link...");
        try {
            driver.findElement(By.xpath("//*[@id='gb_71']")).click();
        }catch (TimeoutException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public String getConfirmationPopUp() {
        LOGGER.info("Inbox page: Getting Confirmation popup message...");
        String msg = "";
        try {
            msg = super.findVisibleElementWithTimeout(CONFIRMATION_POPUP, 5).getText();
            LOGGER.info("Inbox page: Actual PopUp message = " + "\"" + msg + "\"");
        }catch (StaleElementReferenceException e){
            LOGGER.error(e.getMessage());
        }
        return msg;
    }

    public boolean checkInboxPageTitle(String title) {
        if(super.getPageTitle().contains(title)) {
            LOGGER.info("Inbox page: Inbox page title is correct.");
            return true;
        }else{
            LOGGER.info("Inbox page: Inbox page title is incorrect.");
            return false;
        }
    }
}
