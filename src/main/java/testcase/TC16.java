package testcase;

import common.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.HomePage;
import page.LoginPage;
import page.MyTicketPage;

import java.time.Duration;

public class TC16 extends BaseTest {

    @Test(description = "User can cancel a ticket")
    public void TC16() {
        try {
            test.createNode("Step 1. Go to Login and login with valid account");

            LoginPage loginPage = homePage.goToLoginPage();
            HomePage homePage = loginPage.login(account);

            test.createNode("Step 2. Book a ticket with default info");
            BookTicketPage bookTicketPage = homePage.goToBookTicketPage();
            bookTicketPage.bookTicket();

            test.createNode("Step 3. Go to My Ticket page and cancel newest ticket");
            MyTicketPage myTicketPage = bookTicketPage.goToMyTicketPage();
            int currentTotalTicket = myTicketPage.getTotalCancelableTicket();
            myTicketPage.cancelTicket();

            WebDriverWait wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(10));
            wait.until((webDriver -> myTicketPage.getTotalCancelableTicket() == currentTotalTicket - 1));
            test.pass("Ticket removed from table");
        } catch (TimeoutException e) {
            test.fail("The ticket is not disappear");
        }  catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }
    }
}
