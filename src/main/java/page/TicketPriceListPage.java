package page;

import common.Driver;
import org.openqa.selenium.By;

public class TicketPriceListPage extends BasePage {

    public static final String HEADER = "Train ticket pricing list";

    public void checkPrice(String departStation, String arriveStation) {
        String xpathString = "//tr[td[li[.='%s to %s']]]//a[@class='BoxLink']";
        By btnCheckPrice = By.xpath(xpathString);
        Driver.getDriver().findElement(btnCheckPrice).click();
        // Return new page here
    }



}
