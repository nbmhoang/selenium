package page;

import common.Driver;
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
        return Driver.getDriver().findElement(homeTab);
    }

    protected WebElement getFAQTab() {
        return Driver.getDriver().findElement(FAQTab);
    }

    protected WebElement getContactTab() {
        return Driver.getDriver().findElement(contactTab);
    }

    protected WebElement getTimetableTab() {
        return Driver.getDriver().findElement(timetableTab);
    }

    protected WebElement getTicketPriceTab() {
        return Driver.getDriver().findElement(ticketPriceTab);
    }

    protected WebElement getBookTicketTab() {
        return Driver.getDriver().findElement(bookTicketTab);
    }

    protected WebElement getRegisterTab() {
        return Driver.getDriver().findElement(registerTab);
    }

    protected WebElement getLoginTab() {
        return Driver.getDriver().findElement(loginTab);
    }

    protected WebElement getMyTicketTab() {
        return Driver.getDriver().findElement(myTicketTab);
    }

    protected WebElement getChangePasswordTab() {
        return Driver.getDriver().findElement(changePasswordTab);
    }

    protected WebElement getLogoutTab() {
        return Driver.getDriver().findElement(logoutTab);
    }

    protected WebElement getPageHeader() {
        return Driver.getDriver().findElement(pageHeader);
    }

    protected WebElement getWelcomeMessage() {
        return Driver.getDriver().findElement(welcomeMessage);
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
        return Driver.getDriver().findElements(myTicketTab).size() != 0;
    }

    public boolean isChangePasswordTabDisplayed() {
        return Driver.getDriver().findElements(changePasswordTab).size() != 0;
    }

    public boolean isLogoutTabDisplayed() {
        return Driver.getDriver().findElements(logoutTab).size() != 0;
    }
}
