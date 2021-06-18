package testcase;

import data.Account;
import org.testng.annotations.Test;
import page.LoginPage;

public class TC02 extends BaseTest {

    /*
    @Test(description = "User can't login with blank \"Username\" textbox")
    public void TC02() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();
            Account account = new Account("", "123456789");

            test.log(LogStatus.INFO, String.format("Step 2. Login with blank username and password is %s", account.getPassword()));
            loginPage.login(account);

            test.log(LogStatus.INFO, "Step 3. Check the error is display or not");
            if (loginPage.isErrorDisplay()) {
                String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";
                String actualErrorMessage = loginPage.getErrorMessageContent();
                if (actualErrorMessage.equals(expectedErrorMessage)) {
                    test.log(LogStatus.PASS, "User can't login with blank \"Username\"");
                } else {
                    test.log(LogStatus.FAIL, String.format("The error message content doesn't correctly. Expected: '%s' but received '%s'", expectedErrorMessage, actualErrorMessage));
                }
            } else {
                test.log(LogStatus.FAIL, "The error message doesn't display");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */

}
