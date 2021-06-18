package testcase;

import common.Utis;
import data.RegisterInfo;
import org.testng.annotations.Test;
import page.RegisterPage;

public class TC11 extends BaseTest {

    /*
    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Register page");
            RegisterPage registerPage = homePage.goToRegisterPage();

            test.log(LogStatus.INFO, "Step 2. Register with valid email address and leave other fields empty");
            RegisterInfo data = Utis.generateRandomAccount();
            data.setPassword("");
            data.setConfirmPassword("");
            data.setPID("");
            registerPage.register(data);

            test.log(LogStatus.INFO, "Step 3. Check the error message and validation error for each field");
            if (registerPage.isErrorMessageDisplayed()) {
                String actualMessage = registerPage.getErrorMessageContent();
                String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
                if (expectedMessage.equals(actualMessage)) {
                    test.log(LogStatus.PASS, "Error message is display correctly");
                } else {
                    test.log(LogStatus.FAIL, String.format("Error is not display correctly. Expected: '%s' but received '%s'", expectedMessage, actualMessage));
                }
            } else {
                test.log(LogStatus.FAIL, "Error message is not display");
            }

            if (registerPage.isPasswordValidationErrorDisplayed()) {
                String expectedMessage = "Invalid password length.";
                String actualMessage = registerPage.getPasswordValidationError();
                if (expectedMessage.equals(actualMessage)) {
                    test.log(LogStatus.PASS, "Password validation error is display correctly");
                } else {
                    test.log(LogStatus.FAIL, String.format("Password validation error is not display correctly. Expected: '%s' but receive '%s'", expectedMessage, actualMessage));
                }

            } else {
                test.log(LogStatus.FAIL, "Password validation error is not display");
            }

            if (registerPage.isPIDValidationErrorDisplayed()) {
                String expectedMessage = "Invalid ID length.";
                String actualMessage = registerPage.getPIDValidationError();
                if (expectedMessage.equals(actualMessage)) {
                    test.log(LogStatus.PASS, "PID validation error is display correctly");
                } else {
                    test.log(LogStatus.FAIL, String.format("PID validation error is not display correctly. Expected '%s' but received '%s'", expectedMessage, actualMessage));
                }
            } else {
                test.log(LogStatus.FAIL, "PID validation error is not display");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }
    }

     */
}
