package page;


import common.Driver;
import data.Ticket;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends BasePage {

    public static final String HEADER = "Manage Tickets";

    private final By filterTable = By.xpath("//div[@class='Filter']");
    private final By ticketTable = By.xpath("//table[@class='MyTable']");
    private final By departStationSelection = By.xpath("//select[@name='FilterDpStation']");
    private final By arriveStationSelection = By.xpath("//select[@name='FilterArStation']");
    private final By inputDepartDate = By.xpath("//input[@name='FilterDpDate']");
    private final By ticketStatusSelection = By.xpath("//select[@name='FilterStatus']");
    private final By btnFilter = By.xpath("//input[@type='submit']");
    private final By btnCancel = By.xpath("//input[@type='button' and @value='Cancel']");
    private final By btnDelete = By.xpath("//input[@type='button' and @value='Delete']");

    private WebElement getTicketTable() {
        return Driver.getDriver().findElement(ticketTable);
    }

    private Select getDepartStationSelection() {
        return new Select(Driver.getDriver().findElement(departStationSelection));
    }

    private Select getArriveStationSelection() {
        return new Select(Driver.getDriver().findElement(arriveStationSelection));
    }

    private WebElement getInputDepartDate() {
        return Driver.getDriver().findElement(inputDepartDate);
    }

    private Select getTicketStatusSelection() {
        return new Select(Driver.getDriver().findElement(ticketStatusSelection));
    }

    private WebElement getBtnFilter() {
        return Driver.getDriver().findElement(btnFilter);
    }

    private WebElement getBtnCancel() {
        return Driver.getDriver().findElement(btnCancel);
    }

    private WebElement getBtnDelete() {
        return Driver.getDriver().findElement(btnDelete);
    }

    public void filterTicket(String departStation, String arriveStation, String departDate, String ticketStatus) {
        getDepartStationSelection().selectByVisibleText(departStation);
        getArriveStationSelection().selectByVisibleText(arriveStation);
        getInputDepartDate().sendKeys(departDate);
        getTicketStatusSelection().selectByVisibleText(ticketStatus);
        getBtnFilter().click();
    }

    public int getTotalTicket() {
        return Driver.getDriver().findElements(By.xpath("//table[@class='MyTable']//tr")).size() - 1;
    }

    public int getTotalCancelableTicket() {
        return Driver.getDriver().findElements(btnCancel).size();
    }

    public int getTotalDeletableTicket() {
        return Driver.getDriver().findElements(btnDelete).size();
    }

    // Delete first deletable ticket
    public void deleteTicket() {
        getBtnDelete().click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    // Cancel first cancelable ticket
    public void cancelTicket() {
        getBtnCancel().click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    public void cancelTicket(Ticket ticket) {

    }

    public void deleteTicket(Ticket ticket) {

    }

    public void deleteOrRemoveTicket(Ticket ticket) {
        switch (ticket.getStatus()) {
            case Ticket.EXPIRED_TICKET: {
                deleteTicket(ticket);
                break;
            }
            case Ticket.NEW_TICKET: {
                cancelTicket(ticket);
                break;
            }
        }
    }

}
