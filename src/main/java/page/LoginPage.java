package page;

import static common.Driver.webDriver;

import common.Utis;
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
        return webDriver.findElement(inputEmail);
    }

    private WebElement getInputPassword() {
        return webDriver.findElement(inputPassword);
    }

    private WebElement getBtnLogin() {
        return webDriver.findElement(btnLogin);
    }

    private WebElement getErrorMessage() {
        return webDriver.findElement(errorMessage);
    }

    private WebElement getHyperlinkRegistrationPage() {
        return webDriver.findElement(hyperlinkRegistrationPage);
    }

    private WebElement getHyperlinkForgotPassword() {
        return webDriver.findElement(hyperlinkForgotPasswordPage);
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
        Utis.scrollToEnd();
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
        return webDriver.findElements(errorMessage).size() != 0;
    }

    public String getErrorMessageContent() {
        return getErrorMessage().getText();
    }


}
