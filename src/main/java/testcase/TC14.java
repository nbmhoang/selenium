package testcase;

import data.Ticket;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.HomePage;
import page.LoginPage;
import page.SuccessPage;

public class TC14 extends BaseTest {

    /*
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

     */

}
