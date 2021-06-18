package testcase;

import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.LoginPage;
import page.MyTicketPage;

public class TC06 extends BaseTest {

    /*
    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = homePage.goToLoginPage();

            test.log(LogStatus.INFO, "Step 2. Login with valid account");

            loginPage.login(account);

            test.log(LogStatus.INFO, "Step 3. Check \"My ticket\", \"Change password\" and \"Logout\" tabs are displayed.");
            if (homePage.isMyTicketTabDisplayed() && homePage.isChangePasswordTabDisplayed() && homePage.isLogoutTabDisplayed()) {

                test.log(LogStatus.INFO, "Step 4. Check My Ticket page is display when user click on My Ticket tab");
                MyTicketPage myTicketPage = homePage.goToMyTicketPage();
                String currentPage = myTicketPage.getCurrentPageHeader();

                if (currentPage.equals(MyTicketPage.HEADER)) {
                    test.log(LogStatus.PASS, "My Ticket page is display when user click on My Ticket tab");
                } else {
                    test.log(LogStatus.FAIL, "My Ticket page isn't display when user click on My Ticket tab");
                }

                test.log(LogStatus.INFO, "Step 5. Check Change Password page is display when user click on Change Password tab");
                ChangePasswordPage changePasswordPage = myTicketPage.goToChangePasswordPage();
                currentPage = changePasswordPage.getCurrentPageHeader();
                if (currentPage.equals("Change password")) {
                    test.log(LogStatus.PASS, "Change Password page is display when user click on My Ticket tab");
                } else {
                    test.log(LogStatus.FAIL, "Change Password page isn't display when user click on My Ticket tab");
                }
            } else {
                test.log(LogStatus.FAIL, "One or more tabs are not display");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */
}
