package testcase;

import static common.Driver.webDriver;

import common.Constant;
import common.Driver;
import common.TicketFilter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class BaseTest {

    private HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        String browser = context.getCurrentXmlTest().getParameter("browser");
        String pathToDriver = context.getCurrentXmlTest().getParameter("path");
        Driver.initDriver(browser, pathToDriver);
        webDriver.get(Constant.RAILWAY_URL);
        webDriver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void TC01() {
        // TODO: Write below
    }


}
