package testcase;

import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test(description = "User can't login with an account hasn't been activated", enabled = false)
    public void TC08() {
        test.skip("Can't create unactivated account");
    }


}
