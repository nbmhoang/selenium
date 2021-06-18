package testcase;

import com.aventstack.extentreports.ExtentTest;
import common.Utils;
import data.RegisterInfo;
import org.testng.annotations.Test;
import page.RegisterPage;

public class TC11 extends BaseTest {

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        try {
            test.createNode("Step 1. Go to Register page");
            RegisterPage registerPage = homePage.goToRegisterPage();

            test.createNode("Step 2. Register with valid email address and leave other fields empty");
            RegisterInfo data = Utils.generateRandomAccount();
            data.setPassword("");
            data.setConfirmPassword("");
            data.setPID("");
            registerPage.register(data);

            ExtentTest finalStep = test.createNode("Step 3. Check the error message and validation error for each field");
            if (registerPage.isErrorMessageDisplayed()) {
                String actualMessage = registerPage.getErrorMessageContent();
                String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
                if (expectedMessage.equals(actualMessage)) {
                    test.info("Error message is display correctly");
                } else {
                    test.fail("Error is not display correctly");
                    finalStep.info(String.format("Expected: '%s'", expectedMessage));
                    finalStep.info(String.format("Actual: '%s'", actualMessage));
                }
            } else {
                test.fail("Error message is not display");
            }

            if (registerPage.isPasswordValidationErrorDisplayed()) {
                String expectedMessage = "Invalid password length.";
                String actualMessage = registerPage.getPasswordValidationError();
                if (expectedMessage.equals(actualMessage)) {
                    test.pass("Password validation error is display correctly");
                } else {
                    test.fail("Password validation error is not display correctly");
                    finalStep.info(String.format("Expected: '%s'", expectedMessage));
                    finalStep.info(String.format("Actual: '%s'", actualMessage));
                }

            } else {
                test.fail("Password validation error is not display");
            }

            if (registerPage.isPIDValidationErrorDisplayed()) {
                String expectedMessage = "Invalid ID length.";
                String actualMessage = registerPage.getPIDValidationError();
                if (expectedMessage.equals(actualMessage)) {
                    test.pass("PID validation error is display correctly");
                } else {
                    test.fail("PID validation error is not display correctly");
                    finalStep.info(String.format("Expected: '%s'", expectedMessage));
                    finalStep.info(String.format("Actual: '%s'", actualMessage));
                }
            } else {
                test.fail("PID validation error is not display");
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }
    }
}
