package testcase;

import static common.Driver.webDriver;

import common.Constant;
import common.Driver;
import common.Utis;
import data.Account;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import page.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    protected HomePage homePage = new HomePage();
    private static final String reportPath = Utis.generateReportPath();
    private final String URL = System.getenv("URL");
    protected final Account account = new Account(System.getenv("USERNAME"), System.getenv("PASSWORD"));

//    protected static ExtentReports reports;
//    protected static ExtentTest test;

    @BeforeSuite
    public static void beforeClass() {
//        reports = new ExtentReports(reportPath);
    }

    @BeforeMethod
    @Parameters(value = {"browser", "path"})
    public void beforeMethod(String browser, String path, Method method) {
        Test t = method.getAnnotation(Test.class);
//        test = reports.startTest(String.format("%s - %s", method.getName(), t.description()));

        Driver.initDriver(browser, path);
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
//        reports.endTest(test);
        webDriver.quit();
    }


    @AfterSuite
    public static void afterClass() throws IOException {
//        reports.flush();

        // Open the report after done
        File htmlFile = new File(reportPath);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

}
