package page;

import common.Driver;
import org.openqa.selenium.By;

public class FAQPage extends BasePage {

    public static final String HEADER = "Frequently Asked Questions";

    public void goToQuestion(int questionIndex) {
        Driver.getDriver().findElement(By.xpath(String.format("//a[@href='#%d']", questionIndex))).click();
    }

}
