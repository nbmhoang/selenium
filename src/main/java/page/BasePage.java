package page;

import static common.Driver.webDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    private By tabHome = By.xpath("//div[@id='menu']//a[@href='../']");
    private By tabFAQ = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
    private By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
    private By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
    private By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");

    private By welcomeMessage = By.xpath("//div[@id='banner']/div[@class='account']/strong");

    protected WebElement getTabHome() {
        return webDriver.findElement(tabHome);
    }

    protected WebElement getTabFAQ() {
        return webDriver.findElement(tabFAQ);
    }

    protected WebElement getTabContact() {
        return webDriver.findElement(tabContact);
    }

    protected WebElement getTabTimetable() {
        return webDriver.findElement(tabTimetable);
    }

    protected WebElement getTabTicketPrice() {
        return webDriver.findElement(tabTicketPrice);
    }

    protected WebElement getTabBookTicket() {
        return webDriver.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return webDriver.findElement(tabRegister);
    }

    protected WebElement getTabLogin() {
        return webDriver.findElement(tabLogin);
    }

    protected WebElement getTabMyTicket() {
        return webDriver.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return webDriver.findElement(tabChangePassword);
    }

    protected WebElement getTabLogout() {
        return webDriver.findElement(tabLogout);
    }

    protected WebElement getWelcomeMessage() {
        return webDriver.findElement(welcomeMessage);
    }

    public String getWelcomeMessageContent() {
        return getWelcomeMessage().getText();
    }

    public LoginPage goToLoginPage() {
        getTabLogin().click();
        return new LoginPage();
    }

    public MyTicketPage goToMyTicketPage() {
        getTabMyTicket().click();
        return new MyTicketPage();
    }

    public FAQPage goToFAQPage() {
        getTabFAQ().click();
        return new FAQPage();
    }
}
