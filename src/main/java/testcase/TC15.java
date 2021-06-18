package testcase;

import org.testng.annotations.Test;
import page.BookTicketPage;
import page.HomePage;
import page.LoginPage;
import page.TimetablePage;

public class TC15 extends BaseTest {

    /*
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

     */

}
