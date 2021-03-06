package common;

import data.RegisterInfo;
import org.openqa.selenium.JavascriptExecutor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utils {

    private static final String dateTimePattern = "yyyyMMdd_HHmmss";
    private static final String LETTER_SPACE = "ABCDEFGHIJKLMNOPQRSTUVWYXZabcdefghijklmnopqrstuvwyxz";

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < length; i++) {
            str.append(LETTER_SPACE.charAt(random.nextInt(LETTER_SPACE.length())));
        }
        return str.toString();
    }

    public static String generateReportPath() {
        return String.format("%sreport_%s.html", System.getProperty("user.dir"), new SimpleDateFormat(dateTimePattern).format(Calendar.getInstance().getTime()));
    }

    public static RegisterInfo generateRandomAccount() {
        String email = String.format(String.format("%s@%s.%s", generateRandomString(8), generateRandomString(4), generateRandomString(3)));
        String password = generateRandomString(8);
        String PID = generateRandomString(8);
        RegisterInfo data = new RegisterInfo();
        data.setEmail(email);
        data.setPassword(password);
        // Confirm password is the same as password
        data.setConfirmPassword(password);
        data.setPID(PID);
        return data;
    }

    public static void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scrollTo(0, document.body.scrollHeight)");
    }

}
