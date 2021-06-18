package page;

import common.Utis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class TimetablePage extends BasePage {

    public static final String HEADER = "Train Timetable";

    private final int departStationIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Depart Station']/preceding-sibling::th")).size() + 1;
    private final int arriveStationIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Arrive Station']/preceding-sibling::th")).size() + 1;
    private final int btnCheckPriceIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Check Price']/preceding-sibling::th")).size() + 1;
    private final int btnBookTicketIdx = webDriver.findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Book ticket']/preceding-sibling::th")).size() + 1;
    private final String xpathString = "//table[@class='MyTable WideTable']/tbody/tr[td[%d][.='%s'] and td[%d][.='%s']]/td[%d]";

    private WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        By btnCheckPrice = By.xpath(String.format(xpathString, departStationIdx, departStation, arriveStationIdx, arriveStation, btnCheckPriceIdx));
        return webDriver.findElement(btnCheckPrice);
    }

    private WebElement getBtnBookTicket(String departStation, String arriveStation) {
        By btnCheckPrice = By.xpath(String.format(xpathString, departStationIdx, departStation, arriveStationIdx, arriveStation, btnBookTicketIdx));
        return webDriver.findElement(btnCheckPrice);
    }

    public TicketPriceListPage checkPrice(String departStation, String arriveStation) {
        Utis.scrollToEnd();
        getBtnCheckPrice(departStation, arriveStation).click();
        return new TicketPriceListPage();
    }

    public BookTicketPage bookTicket(String departStation, String arriveStation) {
        Utis.scrollToEnd();
        getBtnBookTicket(departStation, arriveStation).click();
        return new BookTicketPage();
    }

}
