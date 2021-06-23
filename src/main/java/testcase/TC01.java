package testcase;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import page.LoginPage;

public class TC01 extends BaseTest {

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        try {
            test.assignCategory("Login");
            test.createNode("Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();
            ExtentTest node = test.createNode("Step 2. Login with valid account");
            node.info(String.format("Email: '%s'", account.getEmail()));
            node.info(String.format("Password: '%s'", account.getPassword()));
            ExtentTest finalStep = test.createNode("Step 3. Get welcome message and check is it correct");
            String welcomeMessage = loginPage.login(account).getWelcomeMessageContent();
            if (welcomeMessage.equals(String.format("Welcome %s", account.getEmail()))) {
                test.pass("User logged in successfully");
            } else {
                test.fail("Welcome message display doesn't correctly");
                finalStep.info(String.format("Expected: Welcome %s", account.getEmail()));
                finalStep.info(String.format("Actual: %s", welcomeMessage));
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }

}
