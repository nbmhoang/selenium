package testcase;

import org.testng.annotations.Test;
import page.LoginPage;

public class TC01 extends BaseTest {

    /*
    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();

            test.log(LogStatus.INFO, String.format("Step 2. Login with %s as username and %s as password", account.getEmail(), account.getPassword()));
            test.log(LogStatus.INFO, "Step 3. Get welcome message and check is it correct");
            String welcomeMessage = loginPage.login(account).getWelcomeMessageContent();
            if (welcomeMessage.equals(String.format("Welcome %s", account.getEmail()))) {
                test.log(LogStatus.PASS, "User logged in successfully");
            } else {
                test.log(LogStatus.FAIL, "User can't login into Railway");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }
     */

}
