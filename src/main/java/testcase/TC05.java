package testcase;

import data.Account;
import org.testng.annotations.Test;
import page.LoginPage;

public class TC05 extends BaseTest {

    /*
    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = homePage.goToLoginPage();
            Account account = new Account("hoang@gmail.com", "hoanggmail.com");

            test.log(LogStatus.INFO, String.format("Step 2. Login with '%s' as email and '%s' as password 4 times", account.getEmail(), account.getPassword()));
            for(int i = 0; i < 4; i++) {
                loginPage.login(account);
            }

            test.log(LogStatus.INFO, "Step 3. Check the content of error message");
            String actualErrorMessage = loginPage.getErrorMessageContent();
            String expectedErrorMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
            if (expectedErrorMessage.equals(actualErrorMessage)) {
                test.log(LogStatus.PASS, "Message is display correct");
            } else {
                test.log(LogStatus.FAIL, String.format("Wrong message. Expected: '%s' but received '%s'", expectedErrorMessage, actualErrorMessage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */
}
