package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    //Login page object
    private LoginPage loginPage;

    @BeforeSuite
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.goToLoginPage(BASE_URL);
        Assert.assertTrue(loginPage.checkLoginPageTitle(LOGIN_PAGE_TITLE), "Login page title not equals: ");
    }

   @Test(priority = 0, description = "Login with an invalid login")
    public void loginToGmailNegativeInvalidLoginTest() {
        loginPage.clickSignInLink();
        loginPage.typeAccount(INVALID_ACCOUNT);
        loginPage.clickNextButton();
        Assert.assertEquals(loginPage.getAccountErrorMessage(), INVALID_ACCOUNT_ERROR_MSG);
    }

    @Test(priority = 1, description = "Login with an invalid password")
    public void loginToGmailNegativeInvalidPasswordTest() {
        loginPage.clickSignInLink();
        loginPage.typeAccount(ACCOUNT);
        loginPage.clickNextButton();
        loginPage.typePassword(INVALID_PASSWORD);
        loginPage.clickPasswordNextButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), INVALID_PASSWORD_ERROR_MSG);
    }

    @Test(priority = 2, description = "Login with an empty login")
    public void loginToGmailNegativeEmptyLoginTest() {
        loginPage.clickSignInLink();
        loginPage.typeAccount(EMPTY_ACCOUNT);
        loginPage.clickNextButton();
        Assert.assertEquals(loginPage.getAccountErrorMessage(), EMTY_ACCOUNT_ERROR_MSG);
    }

    @Test(priority = 3, description = "Login with an empty password")
    public void loginToGmailNegativeEmptyPasswordTest() {
        loginPage.clickSignInLink();
        loginPage.typeAccount(ACCOUNT);
        loginPage.clickNextButton();
        loginPage.typePassword(EMPTY_PASSWORD);
        loginPage.clickPasswordNextButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), EMPTY_PASSWORD_ERROR_MSG);
    }

    @Test(priority = 4, description = "Login with a valid credentials")
    public void loginToGmailPositiveTest() throws InterruptedException {
        loginPage.clickSignInLink();
        loginPage.typeAccount(ACCOUNT);
        loginPage.clickNextButton();
        loginPage.typePassword(PASSWORD);
        loginPage.clickPasswordNextButton();
    }

}
