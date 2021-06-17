package page;

import data.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class SuccessPage extends BookTicketPage {

    private int departStationIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Depart Station']/preceding-sibling::th")).size() + 1;
    private int arriveStationIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Arrive Station']/preceding-sibling::th")).size() + 1;
    private int seatTypeIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Seat Type']/preceding-sibling::th")).size() + 1;
    private int departDateIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Depart Date']/preceding-sibling::th")).size() + 1;
    private int amountIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Amount']/preceding-sibling::th")).size() + 1;

    private By departStation = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", departStationIdx));
    private By arriveStation = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", arriveStationIdx));
    private By seatType = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", seatTypeIdx));
    private By departDate = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", departDateIdx));
    private By amount = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", amountIdx));

    private WebElement getDepartStationElement() {
        return webDriver.findElement(departStation);
    }

    private WebElement getArriveStationElement() {
        return webDriver.findElement(arriveStation);
    }

    private WebElement getSeatTypeElement() {
        return webDriver.findElement(seatType);
    }

    private WebElement getDepartDateElement() {
        return webDriver.findElement(departDate);
    }

    private WebElement getAmountElement() {
        return webDriver.findElement(amount);
    }

    public String getDepartStation() {
        return getDepartStationElement().getText();
    }

    public String getArriveStation() {
        return getArriveStationElement().getText();
    }

    public String getSeatType() {
        return getSeatTypeElement().getText();
    }

    public String getDepartDate() {
        return getDepartDateElement().getText();
    }

    public int getAmount() {
        return Integer.parseInt(getAmountElement().getText());
    }

    public boolean checkTicket(Ticket ticket) {
        return getDepartStation().equals(ticket.getDepartFrom()) &&
                getArriveStation().equals(ticket.getArriveAt()) &&
                getSeatType().equals(ticket.getSeatType()) &&
                getDepartDate().equals(ticket.getDepartDate()) &&
                getAmount() == ticket.getAmount();
    }

}
