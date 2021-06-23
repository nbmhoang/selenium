package testcase;

import com.aventstack.extentreports.ExtentTest;
import data.Account;
import org.testng.annotations.Test;
import page.LoginPage;

public class TC02 extends BaseTest {

    @Test(description = "User can't login with blank \"Username\" textbox")
    public void TC02() {
        try {
            test.assignCategory("Login");
            test.createNode("Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();
            Account account = new Account("", "123456789");

            ExtentTest step2 = test.createNode("Step 2. Login with blank username");
            step2.info("Username: <blank>");
            step2.info(String.format("Password: '%s'", account.getPassword()));
            loginPage.login(account);

            ExtentTest finalStep = test.createNode("Step 3. Check the error is display or not");
            if (loginPage.isErrorDisplay()) {
                String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";
                String actualErrorMessage = loginPage.getErrorMessageContent();
                if (actualErrorMessage.equals(expectedErrorMessage)) {
                    test.pass("User can't login with blank \"Username\"");
                } else {
                    test.fail("The error message content doesn't correctly");
                    finalStep.info(String.format("Expected: %s", expectedErrorMessage));
                    finalStep.info(String.format("Actual: %s", actualErrorMessage));
                }
            } else {
                test.fail("The error message doesn't display");
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }
}
