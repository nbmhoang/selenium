package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class RegisterPage extends BasePage {

    private By inputEmail = By.id("email");
    private By inputPassword = By.id("password");
    private By inputConfirmPassword = By.id("confirmPassword");
    private By inputPID = By.id("pid");
    private By btnRegister = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//p[@class='message error']");

    private By hyperlinkLoginPage = By.linkText("login");
    private By hyperlinkConfirmationPage = By.linkText("here");

    private WebElement getInputEmail() {
        return webDriver.findElement(inputEmail);
    }

    private WebElement getInputPassword() {
        return webDriver.findElement(inputPassword);
    }

    private WebElement getInputConfirmPassword() {
        return webDriver.findElement(inputConfirmPassword);
    }

    private WebElement getInputPID() {
        return webDriver.findElement(inputPID);
    }

    private WebElement getBtnRegister() {
        return webDriver.findElement(btnRegister);
    }

    private WebElement getErrorMessage() {
        return webDriver.findElement(errorMessage);
    }

    private WebElement getHyperlinkLogin() {
        return webDriver.findElement(hyperlinkLoginPage);
    }

    private WebElement getHyperlinkConfirmation() {
        return webDriver.findElement(hyperlinkConfirmationPage);
    }

    public String getErrorMessageContent() {
        return getWelcomeMessage().getTagName();
    }

    public void register(String email, String password, String confirmPassword, String PID) {
        getInputEmail().sendKeys(email);
        getInputPassword().sendKeys(password);
        getInputConfirmPassword().sendKeys(confirmPassword);
        getInputPID().sendKeys(PID);

        getBtnRegister().click();
    }

    public LoginPage clickHyperlinkLogin() {
        getHyperlinkLogin().click();
        return new LoginPage();
    }



}
