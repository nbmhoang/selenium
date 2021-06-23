package testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.Driver;
import common.Utils;
import data.Account;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import page.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    protected HomePage homePage = new HomePage();

    // Get data from env
    private final String URL = System.getenv("URL");
    protected final Account account = new Account(System.getenv("USERNAME"), System.getenv("PASSWORD"));

    private static final String reportPath = Utils.generateReportPath();
    protected static ExtentReports reports = new ExtentReports();
    protected ExtentTest test = null;

    @BeforeSuite
    public void beforeSuite() {
        ExtentSparkReporter html = new ExtentSparkReporter(reportPath);
        reports.attachReporter(html);
    }

    @BeforeMethod
    @Parameters(value = {"browser", "path"})
    public void beforeMethod(String browser, String path, Method method) {
        Test t = method.getAnnotation(Test.class);
        test = reports.createTest(method.getName(), t.description());
        test.assignDevice(browser);

        Driver.initDriver(browser, path);
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeBrowser();
    }


    @AfterSuite
    public void afterSuite() throws IOException {
        reports.flush();

        // Open the report after done
        File htmlFile = new File(reportPath);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

}
