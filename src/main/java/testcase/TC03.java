package testcase;


import data.Account;
import org.testng.annotations.Test;
import page.LoginPage;

public class TC03 extends BaseTest {

    /*
    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();
            Account account = new Account("hoang@gmail.com", "69696969");

            test.log(LogStatus.INFO, String.format("Step 2. Login with '%s' as email and '%s' as password", account.getEmail(), account.getPassword()));
            loginPage.login(account);
            if (loginPage.isErrorDisplay()) {
                String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";
                String actualErrorMessage = loginPage.getErrorMessageContent();
                if (actualErrorMessage.equals(expectedErrorMessage)) {
                    test.log(LogStatus.PASS, "User can't login with blank \"Username\" textbox");
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
