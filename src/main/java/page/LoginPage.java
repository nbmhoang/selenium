package page;

import static common.Driver.webDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By inputEmail = By.xpath("//input[@id='username']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//p[@class='message error LoginForm']");
    private By hyperlinkRegistrationPage = By.linkText("Registration Page");
    private By hyperlinkForgotPasswordPage = By.linkText("Forgot Password Page");

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

    public boolean login(String username, String password) {
        getInputEmail().sendKeys(username);
        getInputPassword().sendKeys(password);
        // scroll
        getBtnLogin().click();
        try {
            getErrorMessage();
            return false;
        } catch (NoSuchElementException err) {
            return true;
        }
    }


}
