package testcase;

import common.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.HomePage;
import page.LoginPage;
import page.MyTicketPage;

public class TC16 extends BaseTest {

    /*
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

     */

}
