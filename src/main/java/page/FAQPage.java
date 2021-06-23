package page;

import org.openqa.selenium.By;

import static common.Driver.webDriver;

public class FAQPage extends BasePage {

    public static final String HEADER = "Frequently Asked Questions";

    public void goToQuestion(int questionIndex) {
        webDriver.findElement(By.xpath(String.format("//a[@href='#%d']", questionIndex))).click();
    }

}
