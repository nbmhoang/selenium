package page;

import static common.Driver.webDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    private final By homeTab = By.xpath("//div[@id='menu']//a[@href='../']");
    private final By FAQTab = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
    private final By contactTab = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
    private final By timetableTab = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By ticketPriceTab = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By bookTicketTab = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By registerTab = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By loginTab = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By myTicketTab = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By changePasswordTab = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By logoutTab = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");

    private final By pageHeader = By.xpath("//div[@id='content']/h1[1]");
    private final By welcomeMessage = By.xpath("//div[@id='banner']/div[@class='account']/strong");

    protected WebElement getHomeTab() {
        return webDriver.findElement(homeTab);
    }

    protected WebElement getFAQTab() {
        return webDriver.findElement(FAQTab);
    }

    protected WebElement getContactTab() {
        return webDriver.findElement(contactTab);
    }

    protected WebElement getTimetableTab() {
        return webDriver.findElement(timetableTab);
    }

    protected WebElement getTicketPriceTab() {
        return webDriver.findElement(ticketPriceTab);
    }

    protected WebElement getBookTicketTab() {
        return webDriver.findElement(bookTicketTab);
    }

    protected WebElement getRegisterTab() {
        return webDriver.findElement(registerTab);
    }

    protected WebElement getLoginTab() {
        return webDriver.findElement(loginTab);
    }

    protected WebElement getMyTicketTab() {
        return webDriver.findElement(myTicketTab);
    }

    protected WebElement getChangePasswordTab() {
        return webDriver.findElement(changePasswordTab);
    }

    protected WebElement getLogoutTab() {
        return webDriver.findElement(logoutTab);
    }

    protected WebElement getPageHeader() {
        return webDriver.findElement(pageHeader);
    }

    protected WebElement getWelcomeMessage() {
        return webDriver.findElement(welcomeMessage);
    }

    public String getWelcomeMessageContent() {
        return getWelcomeMessage().getText();
    }

    public boolean isUserLoggedIn() {
        return !getWelcomeMessageContent().equals("Welcome guest!");
    }

    public String getCurrentPageHeader() {
        return getPageHeader().getText();
    }

    public LoginPage goToLoginPage() {
        getLoginTab().click();
        return new LoginPage();
    }

    public MyTicketPage goToMyTicketPage() {
        getMyTicketTab().click();
        return new MyTicketPage();
    }

    public FAQPage goToFAQPage() {
        getFAQTab().click();
        return new FAQPage();
    }

    public ContactPage goToContactPage() {
        getContactTab().click();
        return new ContactPage();
    }

    public TimetablePage goToTimetablePage() {
        getTimetableTab().click();
        return new TimetablePage();
    }

    public TicketPriceListPage goToTicketPricePage() {
        getTicketPriceTab().click();
        return new TicketPriceListPage();
    }

    public BookTicketPage goToBookTicketPage() {
        getBookTicketTab().click();
        return new BookTicketPage();
    }

    public ChangePasswordPage goToChangePasswordPage() {
        getChangePasswordTab().click();
        return new ChangePasswordPage();
    }

    public RegisterPage goToRegisterPage() {
        getRegisterTab().click();
        return new RegisterPage();
    }

    public HomePage logout() {
        getLogoutTab().click();
        return new HomePage();
    }

    public boolean isMyTicketTabDisplayed() {
        return webDriver.findElements(myTicketTab).size() != 0;
    }

    public boolean isChangePasswordTabDisplayed() {
        return webDriver.findElements(changePasswordTab).size() != 0;
    }

    public boolean isLogoutTabDisplayed() {
        return webDriver.findElements(logoutTab).size() != 0;
    }
}
