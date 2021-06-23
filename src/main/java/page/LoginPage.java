package page;


import common.Driver;
import common.Utils;
import data.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public static final String HEADER = "Login Page";

    private final By inputEmail = By.xpath("//input[@id='username']");
    private final By inputPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By hyperlinkRegistrationPage = By.linkText("Registration Page");
    private final By hyperlinkForgotPasswordPage = By.linkText("Forgot Password Page");

    private WebElement getInputEmail() {
        return Driver.getDriver().findElement(inputEmail);
    }

    private WebElement getInputPassword() {
        return Driver.getDriver().findElement(inputPassword);
    }

    private WebElement getBtnLogin() {
        return Driver.getDriver().findElement(btnLogin);
    }

    private WebElement getErrorMessage() {
        return Driver.getDriver().findElement(errorMessage);
    }

    private WebElement getHyperlinkRegistrationPage() {
        return Driver.getDriver().findElement(hyperlinkRegistrationPage);
    }

    private WebElement getHyperlinkForgotPassword() {
        return Driver.getDriver().findElement(hyperlinkForgotPasswordPage);
    }

    public RegisterPage clickHyperlinkRegisterPage() {
        getHyperlinkRegistrationPage().click();
        return new RegisterPage();
    }

    public ForgotPasswordPage clickHyperlinkForgotPasswordPage() {
        getHyperlinkForgotPassword().click();
        return new ForgotPasswordPage();
    }

    public HomePage login(Account account) {
        Utils.scrollToEnd();
        // Clear input before input new one
        WebElement emailInput = getInputEmail();
        WebElement passwordInput = getInputPassword();
        emailInput.clear();
        passwordInput.clear();

        emailInput.sendKeys(account.getEmail());
        passwordInput.sendKeys(account.getPassword());
        // scroll
        getBtnLogin().click();
        return new HomePage();
    }

    public boolean isErrorDisplay() {
        return Driver.getDriver().findElements(errorMessage).size() != 0;
    }

    public String getErrorMessageContent() {
        return getErrorMessage().getText();
    }


}
