package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static common.Driver.webDriver;

public class BookTicketPage extends BasePage {

    private By departDateSelection = By.name("Date");
    private By departStationSelection = By.name("DepartStation");
    private By arriveStationSelection = By.name("ArriveStation");
    private By seatTypeSelection = By.name("SeatType");
    private By ticketAmountSelection = By.name("TicketAmount");
    private By btnBookTicket = By.xpath("//input[@type='submit']");

    private Select getDepartDateSelection() {
        return new Select(webDriver.findElement(departDateSelection));
    }

    private Select getDepartStationSelection() {
        return new Select(webDriver.findElement(departStationSelection));
    }

    private Select getArriveStationSelection() {
        return new Select(webDriver.findElement(arriveStationSelection));
    }

    private Select getSeatTypeSelection() {
        return new Select(webDriver.findElement(seatTypeSelection));
    }

    private Select getTicketAmountSelection() {
        return new Select(webDriver.findElement(ticketAmountSelection));
    }

    private WebElement getBtnBookTicket() {
        return webDriver.findElement(btnBookTicket);
    }

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount) {
        getDepartDateSelection().selectByVisibleText(departDate);
        getDepartStationSelection().selectByVisibleText(departFrom);
        getArriveStationSelection().selectByVisibleText(arriveAt);
        getSeatTypeSelection().selectByVisibleText(seatType);
        getTicketAmountSelection().selectByVisibleText(String.valueOf(ticketAmount));
    }

}