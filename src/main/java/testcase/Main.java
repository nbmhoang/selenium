package testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Main {

    public static void main(String[] args) {
        ExtentReports reports = new ExtentReports();

        ExtentSparkReporter html = new ExtentSparkReporter("index.html");
        reports.attachReporter(html);

        ExtentTest test = reports.createTest("Test");
        test.info("Step 1");

        ExtentTest node = test.createNode("Step 2");
        node.info("Sub step 1.2");
        node.info("Sub step 1.2");
        test.info("Step 3");
        reports.flush();
    }

}
