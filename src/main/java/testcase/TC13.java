package testcase;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TC13 extends BaseTest {


    @Test(description = "Errors display if password and confirm password don't match when resetting password", enabled = false)
    public void TC13() {
        test.log(Status.INFO, "Step 1. Go to Login page and click on 'Forgot Password page' link");
        test.log(Status.INFO, "Step 2. Enter email address");
        test.log(Status.INFO, "Step 3. Click on 'Send Instructions' button");
        test.log(Status.INFO, "Step 4. Open mailbox and click on reset password link");
        test.log(Status.SKIP, "An Internal Server Error occur after click on 'Send Instructions' button and user don't receive the email");
    }

}
