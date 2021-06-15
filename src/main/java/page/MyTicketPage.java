package page;

import static common.Driver.webDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends BasePage {

    private final By filterTable = By.xpath("//div[@class='Filter']");
    private final By departStationSelection = By.xpath("//select[@name='FilterDpStation']");
    private final By arriveStationSelection = By.xpath("//select[@name='FilterArStation']");
    private final By inputDepartDate = By.xpath("//input[@name='FilterDpDate']");
    private final By ticketStatusSelection = By.xpath("//select[@name='FilterStatus']");
    private final By btnFilter = By.xpath("//input[@type='submit']");


    private Select getDepartStationSelection() {
        return new Select(webDriver.findElement(departStationSelection));
    }

    private Select getArriveStationSelection() {
        return new Select(webDriver.findElement(arriveStationSelection));
    }

    private WebElement getInputDepartDate() {
        return webDriver.findElement(inputDepartDate);
    }

    private Select getTicketStatusSelection() {
        return new Select(webDriver.findElement(ticketStatusSelection));
    }

    private WebElement getBtnFilter() {
        return webDriver.findElement(btnFilter);
    }

    public void filterTicket(String departStation, String arriveStation, String departDate, String ticketStatus) {
        getDepartStationSelection().selectByVisibleText(departStation);
        getArriveStationSelection().selectByVisibleText(arriveStation);
        getInputDepartDate().sendKeys(departDate);
        getTicketStatusSelection().selectByVisibleText(ticketStatus);
        getBtnFilter().click();
    }

    public int getTotalTicket() {
        return webDriver.findElements(By.xpath("//table[@class='MyTable']//tr")).size() - 1;
    }

    // TODO
    public void deleteTicket() {

    }

    // TODO
    public void cancelTicket() {

    }

}
