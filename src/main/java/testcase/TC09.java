package testcase;

import com.aventstack.extentreports.ExtentTest;
import data.ChangePasswordInfo;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.HomePage;
import page.LoginPage;

public class TC09 extends BaseTest {

    @Test(description = "User can change password")
    public void TC09() {
        try {
            test.assignCategory("Change Password");
            test.createNode("Step 1. Go to login page and login with valid account");
            LoginPage loginPage = homePage.goToLoginPage();

            HomePage homePage = loginPage.login(account);

            test.createNode("Step 2. Click on Change Password tab");
            ChangePasswordPage changePasswordPage = homePage.goToChangePasswordPage();

            test.createNode("Step 3. Change account password");
            ChangePasswordInfo info = new ChangePasswordInfo(account.getPassword(), account.getPassword(), account.getPassword());
            changePasswordPage.changePassword(info);

            ExtentTest finalStep = test.createNode("Step 4. Check the message is correctly display");
            String expectedMessage = "Your password has been updated";
            String actualMessage = changePasswordPage.getSuccessMessageContent();
            if (expectedMessage.equals(actualMessage)) {
                test.pass("User change password successfully");
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
