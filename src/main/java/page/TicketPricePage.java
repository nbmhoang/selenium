package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {

    public static final String HEADER = "Ticket Price";

    private final By tableHeader = By.xpath("//tr[@class='TableSmallHeader']/th");
    private final By ticketPriceTable = By.xpath("//table[@class='MyTable MedTable']");

    private WebElement getTableHeader() {
        return Driver.getDriver().findElement(tableHeader);
    }

    public String getTableHeaderContent() {
        return getTableHeader().getText();
    }

    public void bookTicket(String seatType) {
        WebElement btnBookTicket = Driver.getDriver().findElement(By.xpath(String.format("//tr[td[.='%s']]/td/a[.='Book ticket']", seatType)));
        btnBookTicket.click();
    }



}
