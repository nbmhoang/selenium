package testcase;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.LoginPage;
import page.MyTicketPage;

public class TC06 extends BaseTest {

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        try {
            test.assignCategory("Login");
            test.createNode("Step 1. Go to login page");
            LoginPage loginPage = homePage.goToLoginPage();

            ExtentTest step2 = test.createNode("Step 2. Login with valid account");
            step2.info(String.format("Email: '%s'", account.getEmail()));
            step2.info(String.format("Password: '%s'", account.getPassword()));

            loginPage.login(account);

            test.createNode("Step 3. Check \"My ticket\", \"Change password\" and \"Logout\" tabs are displayed.");
            if (homePage.isMyTicketTabDisplayed() && homePage.isChangePasswordTabDisplayed() && homePage.isLogoutTabDisplayed()) {

                test.createNode("Step 4. Check My Ticket page is display when user click on My Ticket tab");
                MyTicketPage myTicketPage = homePage.goToMyTicketPage();
                String currentPage = myTicketPage.getCurrentPageHeader();

                if (currentPage.equals(MyTicketPage.HEADER)) {
                    test.pass("My Ticket page is display when user click on My Ticket tab");
                } else {
                    test.fail("My Ticket page isn't display when user click on My Ticket tab");
                }

                test.createNode("Step 5. Check Change Password page is display when user click on Change Password tab");
                ChangePasswordPage changePasswordPage = myTicketPage.goToChangePasswordPage();
                currentPage = changePasswordPage.getCurrentPageHeader();
                if (currentPage.equals("Change password")) {
                    test.pass("Change Password page is display when user click on My Ticket tab");
                } else {
                    test.fail("Change Password page isn't display when user click on My Ticket tab");
                }
            } else {
                test.fail("One or more tabs are not display");
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }
}
