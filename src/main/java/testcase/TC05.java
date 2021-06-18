package testcase;

import com.aventstack.extentreports.ExtentTest;
import data.Account;
import org.testng.annotations.Test;
import page.LoginPage;

public class TC05 extends BaseTest {

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        try {
            test.createNode("Step 1. Go to login page");
            LoginPage loginPage = homePage.goToLoginPage();
            Account account = new Account("hoang@gmail.com", "hoanggmail.com");

            ExtentTest step2 = test.createNode("Step 2. Login with invalid account 4 times");
            for(int i = 0; i < 4; i++) {
                step2.info(String.format("Email: '%s'. Password: '%s'(%d times)", account.getEmail(), account.getPassword(), i+1));
                loginPage.login(account);
            }

            ExtentTest finalStep = test.createNode("Step 3. Check the content of error message");
            String actualErrorMessage = loginPage.getErrorMessageContent();
            String expectedErrorMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
            if (expectedErrorMessage.equals(actualErrorMessage)) {
                test.pass("Message is display correct");
            } else {
                test.fail("Wrong message");
                finalStep.info(String.format("Expected: '%s'", expectedErrorMessage));
                finalStep.info(String.format("Actual: '%s'", actualErrorMessage));
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }
}
