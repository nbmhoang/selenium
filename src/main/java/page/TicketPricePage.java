package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class TicketPricePage extends BasePage {

    public static final String HEADER = "Train ticket pricing list";

    private final By ticketPriceTable = By.xpath("//table[@class='MyTable MedTable']");
    private final By tableHeader = By.xpath("//tr[@class='TableSmallHeader']/th");

    private WebElement getTableHeader() {
        return webDriver.findElement(tableHeader);
    }

    public String getTableHeaderContent() {
        return getTableHeader().getText();
    }

    public void checkPrice(String departStation, String arriveStation) {
        String xpathString = "//tr[td[li[.='%s to %s']]]//a[@class='BoxLink']";
        By btnCheckPrice = By.xpath(xpathString);
    }



}
