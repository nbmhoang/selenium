package page;

import common.Utils;
import data.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static common.Driver.webDriver;

public class BookTicketPage extends BasePage {

    public static final String HEADER = "Book ticket";

    private final By departDateSelection = By.name("Date");
    private final By departStationSelection = By.name("DepartStation");
    private final By arriveStationSelection = By.name("ArriveStation");
    private final By seatTypeSelection = By.name("SeatType");
    private final By ticketAmountSelection = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");

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

    public String getSelectedDepartDate() {
        return getDepartDateSelection().getFirstSelectedOption().getText();
    }

    public String getSelectedDepartStation() {
        return getDepartStationSelection().getFirstSelectedOption().getText();
    }

    public String getSelectedArriveStation() {
        return getArriveStationSelection().getFirstSelectedOption().getText();
    }

    public String getSelectedSeatType() {
        return getSeatTypeSelection().getFirstSelectedOption().getText();
    }

    public int getSelectedTicketAmount() {
        return Integer.parseInt(getTicketAmountSelection().getFirstSelectedOption().getText());
    }

    public SuccessPage bookTicket() {
        Utils.scrollToEnd();
        // Leave all option as default
        getBtnBookTicket().click();
        return new SuccessPage();
    }

    public SuccessPage bookTicket(Ticket ticket) {
        Utils.scrollToEnd();

        if (Objects.nonNull(ticket.getDepartDate())) {
            getDepartDateSelection().selectByVisibleText(ticket.getDepartDate());
        } else {
            // Set first option
            ticket.setDepartDate(getDepartDateSelection().getFirstSelectedOption().getText());
        }
        String defaultDepartStation = getDepartStationSelection().getFirstSelectedOption().getText();
        if (!defaultDepartStation.equals(ticket.getDepartFrom())) {
            getDepartStationSelection().selectByVisibleText(ticket.getDepartFrom());
            List<WebElement> originalOptions = getArriveStationSelection().getAllSelectedOptions();

            // Wait until Arrive At option is change(Up to 10s)
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            wait.until((driver) -> {
                List<WebElement> currentOptions = getArriveStationSelection().getAllSelectedOptions();
                return !originalOptions.equals(currentOptions);
            });
        }
        getArriveStationSelection().selectByVisibleText(ticket.getArriveAt());
        getSeatTypeSelection().selectByVisibleText(ticket.getSeatType());
        getTicketAmountSelection().selectByVisibleText(String.valueOf(ticket.getAmount()));
        getBtnBookTicket().click();
        return new SuccessPage();
    }

}
