package testcase;

import org.testng.annotations.Test;
import page.LoginPage;

public class TC04 extends BaseTest {

    /*
    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        try {
            test.log(LogStatus.INFO, "Step 1. Click on Book Ticket tab");
            String currentPage = homePage.goToBookTicketPage().getCurrentPageHeader();

            test.log(LogStatus.INFO, "Step 2. Check current page is Login Page or not");
            if (currentPage.equals(LoginPage.HEADER)) {
                test.log(LogStatus.PASS, "Login page is display");
            } else {
                test.log(LogStatus.FAIL, String.format("%s page is display instead of Login page", currentPage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */

}
