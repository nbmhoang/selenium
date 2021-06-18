package testcase;

import data.ChangePasswordInfo;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.HomePage;
import page.LoginPage;

public class TC09 extends BaseTest {

    /*
    @Test(description = "User can change password")
    public void TC09() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page and login with valid account");
            LoginPage loginPage = homePage.goToLoginPage();

            HomePage homePage = loginPage.login(account);

            test.log(LogStatus.INFO, "Step 2. Click on Change Password tab");
            ChangePasswordPage changePasswordPage = homePage.goToChangePasswordPage();

            test.log(LogStatus.INFO, "Step 3. Change password to %s");
            ChangePasswordInfo info = new ChangePasswordInfo(account.getPassword(), account.getPassword(), account.getPassword());
            changePasswordPage.changePassword(info);

            test.log(LogStatus.INFO, "Step 4. Check the message is correctly display");
            String expectedMessage = "Your password has been updated";
            String actualMessage = changePasswordPage.getSuccessMessageContent();
            if (expectedMessage.equals(actualMessage)) {
                test.log(LogStatus.PASS, "User change password successfully");
            } else {
                test.log(LogStatus.FAIL, String.format("The message is not correct. Expected: '%s' but received '%s'", expectedMessage, actualMessage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

     */

}
