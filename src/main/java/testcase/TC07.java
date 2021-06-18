package testcase;

import common.Utis;
import data.RegisterInfo;
import org.testng.annotations.Test;
import page.RegisterPage;

public class TC07 extends BaseTest {

    /*
    @Test(description = "User can create new account")
    public void TC07() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to register page");
            RegisterPage registerPage = homePage.goToRegisterPage();
            RegisterInfo data = Utis.generateRandomAccount();

            test.log(LogStatus.INFO, String.format("Step 2. Create account with '%s' as email, '%s' is password and '%s' is PID", data.getEmail(), data.getPassword(), data.getPID()));
            registerPage.register(data);
            String expectedMessage = "Thank you for registering your account";
            String actualMessage = registerPage.getResponseMessageContent();

            test.log(LogStatus.INFO, "Step 3. Check the message");
            if (expectedMessage.equals(actualMessage)) {
                test.log(LogStatus.PASS, "User create account successfully");
            } else {
                test.log(LogStatus.FAIL, String.format("The content of message doesn't correct. Expected: '%s' but received '%s'", expectedMessage, actualMessage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */
}
