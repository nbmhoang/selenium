package testcase;

import com.aventstack.extentreports.ExtentTest;
import common.Utils;
import data.RegisterInfo;
import org.testng.annotations.Test;
import page.RegisterPage;

public class TC10 extends BaseTest {

    @Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        try {
            test.createNode("Step 1. Go to Register page");
            RegisterPage registerPage = homePage.goToRegisterPage();
            RegisterInfo data = Utils.generateRandomAccount();
            data.setConfirmPassword(Utils.generateRandomString(8));

            test.createNode("Step 2.  Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
            registerPage.register(data);

            ExtentTest finalStep = test.createNode("Step 3. Check the error message");
            String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
            String actualMessage = registerPage.getErrorMessageContent();
            if (expectedMessage.equals(actualMessage)) {
                test.pass("User can't create account with 'Confirm password' is not the same with 'Password'");
            } else {
                test.fail("The message is not correct");
                finalStep.info(String.format("Expected: '%s'", expectedMessage));
                finalStep.info(String.format("Actual: '%s'", actualMessage));
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }
}
