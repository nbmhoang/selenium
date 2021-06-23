package testcase;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.HomePage;
import page.LoginPage;
import page.TimetablePage;

public class TC15 extends BaseTest {

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        try {
            test.assignCategory("Book Ticket");
            test.createNode("Step 1. Go to Login page and login with valid account");
            LoginPage loginPage = homePage.goToLoginPage();

            HomePage homePage = loginPage.login(account);

            test.createNode("Step 2. Click on 'Timetable' tab");
            TimetablePage timetablePage = homePage.goToTimetablePage();


            String expectedDepartStation = "Huế";
            String expectedArriveStation = "Sài Gòn";
            test.createNode(String.format("Step 3. Click on 'Book ticket' link of the route from '%s' to '%s'", expectedDepartStation, expectedArriveStation));
            BookTicketPage bookTicketPage = timetablePage.bookTicket(expectedDepartStation, expectedArriveStation);

            ExtentTest finalStep = test.createNode(String.format("Step 4. Check 'Book ticket' page is load with Depart from is '%s' and Arrive at is '%s'", expectedDepartStation, expectedArriveStation));
            String currentPage = bookTicketPage.getCurrentPageHeader();
            if (currentPage.equals(BookTicketPage.HEADER)) {
                // Check train info
                String actualDepartStation = bookTicketPage.getSelectedDepartStation();
                String actualArriveStation = bookTicketPage.getSelectedArriveStation();
                if (actualDepartStation.equals("Huế") && actualArriveStation.equals("Sài Gòn")) {
                    test.pass("Book ticket page load correctly");
                } else {
                    test.fail("Wrong book ticket information");
                    finalStep.info(String.format("Expected: %s -> %s", expectedDepartStation, expectedArriveStation));
                    finalStep.info(String.format("Actual: %s -> %s", actualDepartStation, actualArriveStation));
                }
            } else {
                test.fail(String.format("%s page is load instead of Book Ticket page", currentPage));
            }
        } catch (Exception ex) {
            test.fail(String.format("An error has occurred %s", ex.getMessage()));
        }

    }

}
