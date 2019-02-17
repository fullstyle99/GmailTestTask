package tests;

import org.testng.annotations.AfterSuite;
import util.MyWebDriver;

import java.io.IOException;

public class BaseTest {
    //Login page URL
    protected static final String BASE_URL = "https://www.google.com/intl/ru/gmail/about/#";

    //Page titles
    protected static final String LOGIN_PAGE_TITLE = "Gmail";
    protected static final String INBOX_PAGE_TITLE = "Inbox";

    //Invalid credentials error message
    protected static final String INVALID_ACCOUNT_ERROR_MSG = "Couldn't find your Google Account";
    protected static final String INVALID_PASSWORD_ERROR_MSG = "Wrong password. Try again or click Forgot password to reset it.";

    //An empty credentials error message
    protected static final String EMTY_ACCOUNT_ERROR_MSG = "Enter an email or phone number";
    protected static final String EMPTY_PASSWORD_ERROR_MSG = "Enter a password";

    //Valid credentials
    protected static final String ACCOUNT = "your email address here";
    protected static final String PASSWORD = "your password here";


    //Invalid credentials
    protected static final String INVALID_ACCOUNT = ";'/.,25uwMF&!@#";
    protected static final String INVALID_PASSWORD = "1111&!@#&%^)(";

    //Empty credentials
    protected static final String EMPTY_ACCOUNT = "";
    protected static final String EMPTY_PASSWORD = "";

    //Test data
    protected static final String RECIPIENT_EMAIL = "seleniumjavatesttask@gmail.com";
    protected static final String EMAIL_SUBJECT = "Test subject";
    protected static final String EMAIL_MESSAGE = "Hello World!";

    @AfterSuite(alwaysRun = true )
    protected void tearDown() throws IOException {
        MyWebDriver.close();
    }
}
