package testcase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.Utilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Main {

    private ExtentReports report;
    private ExtentTest test;

    @BeforeClass
    public void startTest() {
        String reportPath = Utilities.generatReportPath();
        report = new ExtentReports(reportPath);
        test = report.startTest("ExtentDemo");
    }

    @AfterClass
    public void endTest() {
        report.endTest(test);
        report.flush();
    }

    public void test() {
        test.log(LogStatus.PASS, "Alo alo");
    }
}
