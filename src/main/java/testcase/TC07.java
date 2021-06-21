package testcase;

import com.aventstack.extentreports.ExtentTest;
import common.Utils;
import data.RegisterInfo;
import org.testng.annotations.Test;
import page.RegisterPage;

public class TC07 extends BaseTest {

    @Test(description = "User can create new account")
    public void TC07() {
        try {
            test.assignCategory("Register");
            test.createNode("Step 1. Go to register page");
            RegisterPage registerPage = homePage.goToRegisterPage();
            RegisterInfo data = Utils.generateRandomAccount();

//            test.log(LogStatus.INFO, String.format("Step 2. Create account with '%s' as email, '%s' is password and '%s' is PID", data.getEmail(), data.getPassword(), data.getPID()));
            ExtentTest step2 = test.createNode("Step 2. Create a new account");
            step2.info(String.format("Email: '%s'", data.getEmail()));
            step2.info(String.format("Password: '%s'", data.getPassword()));
            step2.info(String.format("PID: '%s'", data.getPID()));
            registerPage.register(data);
            String expectedMessage = "Thank you for registering your account";
            String actualMessage = registerPage.getResponseMessageContent();

            ExtentTest finalStep = test.createNode("Step 3. Check the message");
            if (expectedMessage.equals(actualMessage)) {
                test.pass("User create account successfully");
            } else {
                test.fail("The content of message doesn't correct");
                finalStep.info(String.format("Expected: '%s'", expectedMessage));
                finalStep.info(String.format("Actual: '%s'", actualMessage));
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }
}
