package testcase;

import com.aventstack.extentreports.ExtentTest;
import data.Ticket;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.HomePage;
import page.LoginPage;
import page.SuccessPage;

public class TC14 extends BaseTest {

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        try {
            test.assignCategory("Book Ticket");
            test.createNode("Step 1. Go to Login page and login with valid account");
            LoginPage loginPage = homePage.goToLoginPage();

            HomePage homePage = loginPage.login(account);

            ExtentTest step2 = test.createNode("Step 2. Click on 'Book Ticket' tab");
            BookTicketPage bookTicketPage = homePage.goToBookTicketPage();

            Ticket ticket = new Ticket();
            ticket.setDepartFrom("Sài Gòn");
            ticket.setArriveAt("Nha Trang");
            ticket.setSeatType(Ticket.SOFT_BED_CONDITIONER);
            ticket.setAmount(1);

            step2.info(String.format("Depart from: '%s'", ticket.getDepartFrom()));
            step2.info(String.format("Arrive at: '%s'", ticket.getArriveAt()));
            step2.info(String.format("Seat type: '%s'", ticket.getSeatType()));
            step2.info(String.format("Amount: '%d'", ticket.getAmount()));

            ExtentTest finalStep = test.createNode("Step 3. Check information of booked ticket");

            SuccessPage successPage = bookTicketPage.bookTicket(ticket);
            if (successPage.getCurrentPageHeader().equals("Ticket Booked Successfully!") && successPage.checkTicket(ticket)) {
                test.pass("User book ticket successfully and ticket ìnfo is correct");
            } else {
                test.fail("Message is not display correct or Ticket info is not correct");
                finalStep.info(String.format("Booked Ticket info: %s", ticket));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }

}
