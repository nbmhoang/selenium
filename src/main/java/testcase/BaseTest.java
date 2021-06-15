package testcase;

import static common.Driver.webDriver;

import common.Constant;
import common.TicketFilter;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void TC00() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isValid = loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        if (isValid) {
            MyTicketPage myTicketPage = homePage.goToMyTicketPage();
            myTicketPage.filterTicket(TicketFilter.IGNORE, TicketFilter.IGNORE, "24/11/2020", TicketFilter.PAID_TICKET);
        }
    }

    @Test
    public void goToLinkTest() {
        homePage.goToCreateAnAccountLink();
    }

    @Test
    public void goToQuestion() {
        FAQPage faqPage = homePage.goToFAQPage();
        for(int i = 1;i < 9;i++) {
            faqPage.goToQuestion(i);
        }
    }

}
