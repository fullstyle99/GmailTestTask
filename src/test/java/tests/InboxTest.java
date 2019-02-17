package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;

public class InboxTest extends BaseTest{
    //Login page object
    private LoginPage loginPage;

    //Inbox page object
    private InboxPage inboxPage;

    @BeforeSuite
    public void setUp() throws InterruptedException {
        loginPage = new LoginPage();
        inboxPage = new InboxPage();
        loginPage.goToLoginPage(BASE_URL);
        Assert.assertTrue(loginPage.checkLoginPageTitle(LOGIN_PAGE_TITLE), "Login page title not equals: ");
        loginPage.clickSignInLink();
        loginPage.typeAccount(ACCOUNT);
        loginPage.clickNextButton();
        loginPage.typePassword(PASSWORD);
        loginPage.clickPasswordNextButton();
    }

    @Test(priority = 5, description = "Compose email")
    public void composeEmailTest() {
        inboxPage.clickOnComposeButton();
        inboxPage.typeRecipientEmail(RECIPIENT_EMAIL);
        inboxPage.typeSubject(EMAIL_SUBJECT);
        inboxPage.typeMessage(EMAIL_MESSAGE);
        inboxPage.clickOnSendButton();
        inboxPage.getConfirmationPopUp();
        Assert.assertTrue(inboxPage.checkInboxPageTitle(INBOX_PAGE_TITLE), "Inbox page title not equals: ");
    }

    @Test(priority = 6, description = "Remove email")
    public void removeEmailTest() {
        inboxPage.openInboxMessage(EMAIL_SUBJECT);
        inboxPage.clickRemoveButton();
        inboxPage.getConfirmationPopUp();
        inboxPage.clicOnAccountLogoLink();
        inboxPage.clicOnLogoutLink();
    }
}
