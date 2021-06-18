package testcase;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import common.Driver;
import common.Utilities;
import data.Account;
import data.ChangePasswordInfo;
import data.RegisterInfo;
import data.Ticket;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.*;

public class Set1 extends BaseTest {

    private final Account account = new Account(Constant.USERNAME, Constant.PASSWORD);

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();

            test.log(LogStatus.INFO, String.format("Step 2. Login with %s as username and %s as password", account.getEmail(), account.getPassword()));
            test.log(LogStatus.INFO, "Step 3. Get welcome message and check is it correct");
            String welcomeMessage = loginPage.login(account).getWelcomeMessageContent();
            if (welcomeMessage.equals(String.format("Welcome %s", account.getEmail()))) {
                test.log(LogStatus.PASS, "User logged in successfully");
            } else {
                test.log(LogStatus.FAIL, "User can't login into Railway");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "User can't login with blank \"Username\" textbox")
    public void TC02() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();
            Account account = new Account("", "123456789");

            test.log(LogStatus.INFO, String.format("Step 2. Login with blank username and password is %s", account.getPassword()));
            loginPage.login(account);

            test.log(LogStatus.INFO, "Step 3. Check the error is display or not");
            if (loginPage.isErrorDisplay()) {
                String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";
                String actualErrorMessage = loginPage.getErrorMessageContent();
                if (actualErrorMessage.equals(expectedErrorMessage)) {
                    test.log(LogStatus.PASS, "User can't login with blank \"Username\"");
                } else {
                    test.log(LogStatus.FAIL, String.format("The error message content doesn't correctly. Expected: '%s' but received '%s'", expectedErrorMessage, actualErrorMessage));
                }
            } else {
                test.log(LogStatus.FAIL, "The error message doesn't display");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = this.homePage.goToLoginPage();
            Account account = new Account("hoang@gmail.com", "69696969");

            test.log(LogStatus.INFO, String.format("Step 2. Login with '%s' as email and '%s' as password", account.getEmail(), account.getPassword()));
            loginPage.login(account);
            if (loginPage.isErrorDisplay()) {
                String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";
                String actualErrorMessage = loginPage.getErrorMessageContent();
                if (actualErrorMessage.equals(expectedErrorMessage)) {
                    test.log(LogStatus.PASS, "User can't login with blank \"Username\" textbox");
                } else {
                    test.log(LogStatus.FAIL, String.format("The error message content doesn't correctly. Expected: '%s' but received '%s'", expectedErrorMessage, actualErrorMessage));
                }
            } else {
                test.log(LogStatus.FAIL, "The error message doesn't display");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        try {
            test.log(LogStatus.INFO, "Step 1. Click on Book Ticket tab");
            String currentPage = homePage.goToBookTicketPage().getCurrentPageHeader();

            test.log(LogStatus.INFO, "Step 2. Check current page is Login Page or not");
            if (currentPage.equals(LoginPage.HEADER)) {
                test.log(LogStatus.PASS, "Login page is display");
            } else {
                test.log(LogStatus.FAIL, String.format("%s page is display instead of Login page", currentPage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = homePage.goToLoginPage();
            Account account = new Account("hoang@gmail.com", "hoanggmail.com");

            test.log(LogStatus.INFO, String.format("Step 2. Login with '%s' as email and '%s' as password 4 times", account.getEmail(), account.getPassword()));
            for(int i = 0; i < 4; i++) {
                loginPage.login(account);
            }

            test.log(LogStatus.INFO, "Step 3. Check the content of error message");
            String actualErrorMessage = loginPage.getErrorMessageContent();
            String expectedErrorMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
            if (expectedErrorMessage.equals(actualErrorMessage)) {
                test.log(LogStatus.PASS, "Message is display correct");
            } else {
                test.log(LogStatus.FAIL, String.format("Wrong message. Expected: '%s' but received '%s'", expectedErrorMessage, actualErrorMessage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to login page");
            LoginPage loginPage = homePage.goToLoginPage();

            test.log(LogStatus.INFO, "Step 2. Login with valid account");
            
            loginPage.login(account);

            test.log(LogStatus.INFO, "Step 3. Check \"My ticket\", \"Change password\" and \"Logout\" tabs are displayed.");
            if (homePage.isMyTicketTabDisplayed() && homePage.isChangePasswordTabDisplayed() && homePage.isLogoutTabDisplayed()) {

                test.log(LogStatus.INFO, "Step 4. Check My Ticket page is display when user click on My Ticket tab");
                MyTicketPage myTicketPage = homePage.goToMyTicketPage();
                String currentPage = myTicketPage.getCurrentPageHeader();

                if (currentPage.equals(MyTicketPage.HEADER)) {
                    test.log(LogStatus.PASS, "My Ticket page is display when user click on My Ticket tab");
                } else {
                    test.log(LogStatus.FAIL, "My Ticket page isn't display when user click on My Ticket tab");
                }

                test.log(LogStatus.INFO, "Step 5. Check Change Password page is display when user click on Change Password tab");
                ChangePasswordPage changePasswordPage = myTicketPage.goToChangePasswordPage();
                currentPage = changePasswordPage.getCurrentPageHeader();
                if (currentPage.equals("Change password")) {
                    test.log(LogStatus.PASS, "Change Password page is display when user click on My Ticket tab");
                } else {
                    test.log(LogStatus.FAIL, "Change Password page isn't display when user click on My Ticket tab");
                }
            } else {
                test.log(LogStatus.FAIL, "One or more tabs are not display");
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "User can create new account")
    public void TC07() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to register page");
            RegisterPage registerPage = homePage.goToRegisterPage();
            RegisterInfo data = Utilities.generateRandomAccount();

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

    @Test(description = "User can't login with an account hasn't been activated", enabled = false)
    public void TC08() {
        test.log(LogStatus.SKIP, "Can't create unactivated account");
    }

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

    @Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Register page");
            RegisterPage registerPage = homePage.goToRegisterPage();
            RegisterInfo data = Utilities.generateRandomAccount();
            data.setConfirmPassword(Utilities.generateRandomString(8));

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

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Register page");
            RegisterPage registerPage = homePage.goToRegisterPage();

            test.log(LogStatus.INFO, "Step 2. Register with valid email address and leave other fields empty");
            RegisterInfo data = Utilities.generateRandomAccount();
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

    @Test(description = "Errors display when password reset token is blank", enabled = false)
    public void TC12() {
        test.log(LogStatus.INFO, "Step 1. Go to Login page and click on 'Forgot Password page' link");
        test.log(LogStatus.INFO, "Step 2. Enter email address");
        test.log(LogStatus.INFO, "Step 3. Click on 'Send Instructions' button");
        test.log(LogStatus.INFO, "Step 4. Open mailbox and click on reset password link");
        test.log(LogStatus.SKIP, "An Internal Server Error occur after click on 'Send Instructions' button and user don't receive the email");
    }

    @Test(description = "Errors display if password and confirm password don't match when resetting password", enabled = false)
    public void TC13() {
        test.log(LogStatus.INFO, "Step 1. Go to Login page and click on 'Forgot Password page' link");
        test.log(LogStatus.INFO, "Step 2. Enter email address");
        test.log(LogStatus.INFO, "Step 3. Click on 'Send Instructions' button");
        test.log(LogStatus.INFO, "Step 4. Open mailbox and click on reset password link");
        test.log(LogStatus.SKIP, "An Internal Server Error occur after click on 'Send Instructions' button and user don't receive the email");
    }

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Login page and login with valid account");
            LoginPage loginPage = homePage.goToLoginPage();
            
            HomePage homePage = loginPage.login(account);

            test.log(LogStatus.INFO, "Step 2. Click on 'Book Ticket' tab");
            BookTicketPage bookTicketPage = homePage.goToBookTicketPage();

            test.log(LogStatus.INFO, "Step 3. Select 'Sài Gòn' for Depart from and 'Nha Trang' for Arrive at");
            test.log(LogStatus.INFO, "Step 4. Select 'Soft bed with air conditioner' for Seat type");
            test.log(LogStatus.INFO, "Step 5. Select '1' for Ticket amount");
            test.log(LogStatus.INFO, "Step 6. Check information of booked ticket");
            Ticket ticket = new Ticket();
            ticket.setDepartFrom("Sài Gòn");
            ticket.setArriveAt("Nha Trang");
            ticket.setSeatType(Ticket.SOFT_BED_CONDITIONER);
            ticket.setAmount(1);
            SuccessPage successPage = bookTicketPage.bookTicket(ticket);
            if (successPage.getCurrentPageHeader().equals("Ticket Booked Successfully!") && successPage.checkTicket(ticket)) {
                test.log(LogStatus.PASS, "User book ticket successfully and ticket ìnfo is correct");
            } else {
                test.log(LogStatus.FAIL, "Message is not display correct or Ticket info is not correct. Ticket info: " + ticket);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Login page and login with valid account");
            LoginPage loginPage = homePage.goToLoginPage();
            
            HomePage homePage = loginPage.login(account);

            test.log(LogStatus.INFO, "Step 2. Click on 'Timetable' tab");
            TimetablePage timetablePage = homePage.goToTimetablePage();

            test.log(LogStatus.INFO, "Step 3. Click on 'Book ticket' link of the route from 'Huế' to 'Sài Gòn'");
            String expectedDepartStation = "Huế";
            String expectedArriveStation = "Sài Gòn";
            BookTicketPage bookTicketPage = timetablePage.bookTicket(expectedDepartStation, expectedArriveStation);

            test.log(LogStatus.INFO, "Step 4. Check 'Book ticket' page is load with Depart from is 'Huế' and Arrive at is 'Sài Gòn'");
            String currentPage = bookTicketPage.getCurrentPageHeader();
            if (currentPage.equals(BookTicketPage.HEADER)) {
                // Check train info
                String actualDepartStation = bookTicketPage.getSelectedDepartStation();
                String actualArriveStation = bookTicketPage.getSelectedArriveStation();
                if (actualDepartStation.equals("Huế") && actualArriveStation.equals("Sài Gòn")) {
                    test.log(LogStatus.PASS, "Book ticket page load correctly");
                } else {
                    test.log(LogStatus.FAIL, String.format("Wrong book ticket information. Expected: %s -> %s. Actual: %s -> %s",
                            expectedDepartStation, expectedArriveStation, actualDepartStation, actualArriveStation));
                }
            } else {
                test.log(LogStatus.FAIL, String.format("%s page is load instead of Book Ticket page", currentPage));
            }
        } catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }

    }

    @Test(description = "User can cancel a ticket")
    public void TC16() {
        try {
            test.log(LogStatus.INFO, "Step 1. Go to Login and login with valid account");
            
            LoginPage loginPage = homePage.goToLoginPage();
            HomePage homePage = loginPage.login(account);

            test.log(LogStatus.INFO, "Step 2. Book a ticket");
            BookTicketPage bookTicketPage = homePage.goToBookTicketPage();
            bookTicketPage.bookTicket();

            MyTicketPage myTicketPage = bookTicketPage.goToMyTicketPage();
            int currentTotalTicket = myTicketPage.getTotalCancelableTicket();
            myTicketPage.cancelTicket();

            WebDriverWait wait = new WebDriverWait(Driver.webDriver, 10);
            wait.until((webDriver -> myTicketPage.getTotalCancelableTicket() == currentTotalTicket - 1));
            test.log(LogStatus.PASS, "Ticket removed from table");
        } catch (TimeoutException e) {
            test.log(LogStatus.FAIL, "The ticket is not disappear");
        }  catch (Exception ex) {
            test.log(LogStatus.FAIL, String.format("An error has occurred %s", ex.getMessage()));
        }
    }
}
