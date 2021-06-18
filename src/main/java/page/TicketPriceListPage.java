package page;

import org.openqa.selenium.By;

import static common.Driver.webDriver;

public class TicketPriceListPage extends BasePage {

    public static final String HEADER = "Train ticket pricing list";

    public void checkPrice(String departStation, String arriveStation) {
        String xpathString = "//tr[td[li[.='%s to %s']]]//a[@class='BoxLink']";
        By btnCheckPrice = By.xpath(xpathString);
        webDriver.findElement(btnCheckPrice).click();
        // Return new page here
    }



}
