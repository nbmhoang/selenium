package page;

import common.Driver;
import common.TicketFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends BasePage {

    private By departStationSelection = By.xpath("//select[@name='FilterDpStation']");
    private By arriveStationSelection = By.xpath("//select[@name='FilterArStation']");
    private By inputDepartDate = By.xpath("//input[@name='FilterDpDate']");
    private By ticketStatusSelection = By.xpath("//select[@name='FilterStatus']");
    private By btnFilter = By.xpath("//input[@type='submit']");


    private Select getDepartStationSelection() {
        return new Select(Driver.webDriver.findElement(departStationSelection));
    }

    private Select getArriveStationSelection() {
        return new Select(Driver.webDriver.findElement(arriveStationSelection));
    }

    private WebElement getInputDepartDate() {
        return Driver.webDriver.findElement(inputDepartDate);
    }

    private Select getTicketStatusSelection() {
        return new Select(Driver.webDriver.findElement(ticketStatusSelection));
    }

    private WebElement getBtnFilter() {
        return Driver.webDriver.findElement(btnFilter);
    }

    public void filterTicket(String departStation, String arriveStation, String departDate, String ticketStatus) {

        getDepartStationSelection().selectByVisibleText(departStation);
        getArriveStationSelection().selectByVisibleText(arriveStation);
        getInputDepartDate().sendKeys(departDate);
        getTicketStatusSelection().selectByVisibleText(ticketStatus);
        getBtnFilter().click();
    }

}
