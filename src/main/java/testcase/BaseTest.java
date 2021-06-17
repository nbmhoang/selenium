package testcase;

import static common.Driver.webDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import common.Constant;
import common.Driver;
import common.Utilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import page.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BaseTest {

    protected HomePage homePage = new HomePage();
    private static String reportPath = Utilities.generatReportPath();

    protected static ExtentReports reports;
    protected static ExtentTest test;

    @BeforeClass
    public static void beforeClass() {
        reports = new ExtentReports(reportPath);
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context, Method method) {
        Test t = method.getAnnotation(Test.class);
        test = reports.startTest(String.format("%s - %s", method.getName(), t.description()));

        String browser = context.getCurrentXmlTest().getParameter("browser");
        String pathToDriver = context.getCurrentXmlTest().getParameter("path");
        Driver.initDriver(browser, pathToDriver);
//        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.get(Constant.RAILWAY_URL);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        reports.endTest(test);
//        webDriver.quit();
    }


    @AfterClass
    public static void afterClass() throws IOException {
        reports.flush();

        // Open the report after done
        File htmlFile = new File(reportPath);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

}
