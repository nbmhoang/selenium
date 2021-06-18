package testcase;

import common.Utis;
import data.RegisterInfo;
import org.testng.annotations.Test;
import page.RegisterPage;

public class TC10 extends BaseTest {

    /*
    @Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Register page");
            RegisterPage registerPage = homePage.goToRegisterPage();
            RegisterInfo data = Utis.generateRandomAccount();
            data.setConfirmPassword(Utis.generateRandomString(8));

            test.log(LogStatus.INFO, "Step 2.  Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
            registerPage.register(data);

            test.log(LogStatus.INFO, "Step 3. Check the error message");
            String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
            String actualMessage = registerPage.getErrorMessageContent();
            if (expectedMessage.equals(actualMessage)) {
                test.log(LogStatus.PASS, "User can't create account with 'Confirm password' is not the same with 'Password'");
            } else {
                test.log(LogStatus.FAIL, String.format("The message is not correct. Expected: '%s' but received: '%s'", expectedMessage, actualMessage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */
}
