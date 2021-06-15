package testcase;

import static common.Driver.webDriver;

import common.Constant;
import common.TicketFilter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class BaseTest {

    private HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {

        webDriver = new ChromeDriver();
        webDriver.get(Constant.RAILWAY_URL);
        webDriver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
//        webDriver.quit();
    }

    @Test
    public void MyTC001() {
        LoginPage loginPage = homePage.goToLoginPage();
//        boolean isValid = loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        boolean isValid = loginPage.login("17it142@sict.udn.vn", "123456789");
        if (isValid) {
            MyTicketPage myTicketPage = homePage.goToMyTicketPage();
//            System.out.println("Total ticket: " + myTicketPage.getTotalTicket());
            int totalTicket = myTicketPage.getTotalTicket();
            if (totalTicket >= 6) {
                myTicketPage.filterTicket(TicketFilter.IGNORE, TicketFilter.IGNORE, "", TicketFilter.NEW_TICKET);
//                TODO: Check filter result
            }
        }
    }

    @Test
    public void MyTC002() {
        homePage.goToCreateAnAccountLink();
    }

    @Test
    public void MyTC003() {
        FAQPage faqPage = homePage.goToFAQPage();
        for(int i = 1;i < 9;i++) {
            faqPage.goToQuestion(i);
        }
    }

    @Test
    public void MyTC004() {
        TimetablePage timetablePage = homePage.goToTimetablePage();
        TicketPricePage ticketPricePage = timetablePage.checkPrice("Huế", "Nha Trang");
        Assert.assertEquals(ticketPricePage.getTableHeaderContent(), String.format("Ticket price from %s to %s", "Huế", "Nha Trang"));
    }

}
