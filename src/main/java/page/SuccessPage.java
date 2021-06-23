package page;

import common.Driver;
import data.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SuccessPage extends BookTicketPage {

    private final int departStationIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Depart Station']/preceding-sibling::th")).size() + 1;
    private final int arriveStationIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Arrive Station']/preceding-sibling::th")).size() + 1;
    private final int seatTypeIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Seat Type']/preceding-sibling::th")).size() + 1;
    private final int departDateIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Depart Date']/preceding-sibling::th")).size() + 1;
    private final int amountIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[@class='TableSmallHeader']/th[.='Amount']/preceding-sibling::th")).size() + 1;

    private final By departStation = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", departStationIdx));
    private final By arriveStation = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", arriveStationIdx));
    private final By seatType = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", seatTypeIdx));
    private final By departDate = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", departDateIdx));
    private final By amount = By.xpath(String.format("//table[@class='MyTable WideTable']/tbody/tr[@class='OddRow']/td[%d]", amountIdx));

    private WebElement getDepartStationElement() {
        return Driver.getDriver().findElement(departStation);
    }

    private WebElement getArriveStationElement() {
        return Driver.getDriver().findElement(arriveStation);
    }

    private WebElement getSeatTypeElement() {
        return Driver.getDriver().findElement(seatType);
    }

    private WebElement getDepartDateElement() {
        return Driver.getDriver().findElement(departDate);
    }

    private WebElement getAmountElement() {
        return Driver.getDriver().findElement(amount);
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
