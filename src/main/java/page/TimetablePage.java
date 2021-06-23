package page;

import common.Driver;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {

    public static final String HEADER = "Train Timetable";

    private final int departStationIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Depart Station']/preceding-sibling::th")).size() + 1;
    private final int arriveStationIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Arrive Station']/preceding-sibling::th")).size() + 1;
    private final int btnCheckPriceIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Check Price']/preceding-sibling::th")).size() + 1;
    private final int btnBookTicketIdx = Driver.getDriver().findElements(By.xpath("//table[@class='MyTable WideTable']/thead/tr/th[.='Book ticket']/preceding-sibling::th")).size() + 1;
    private final String xpathString = "//table[@class='MyTable WideTable']/tbody/tr[td[%d][.='%s'] and td[%d][.='%s']]/td[%d]";

    private WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        By btnCheckPrice = By.xpath(String.format(xpathString, departStationIdx, departStation, arriveStationIdx, arriveStation, btnCheckPriceIdx));
        return Driver.getDriver().findElement(btnCheckPrice);
    }

    private WebElement getBtnBookTicket(String departStation, String arriveStation) {
        By btnCheckPrice = By.xpath(String.format(xpathString, departStationIdx, departStation, arriveStationIdx, arriveStation, btnBookTicketIdx));
        return Driver.getDriver().findElement(btnCheckPrice);
    }

    public TicketPriceListPage checkPrice(String departStation, String arriveStation) {
        Utils.scrollToEnd();
        getBtnCheckPrice(departStation, arriveStation).click();
        return new TicketPriceListPage();
    }

    public BookTicketPage bookTicket(String departStation, String arriveStation) {
        Utils.scrollToEnd();
        getBtnBookTicket(departStation, arriveStation).click();
        return new BookTicketPage();
    }

}
