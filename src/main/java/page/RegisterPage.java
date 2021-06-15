package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class RegisterPage extends BasePage {

    private final By inputEmail = By.id("email");
    private final By inputPassword = By.id("password");
    private final By inputConfirmPassword = By.id("confirmPassword");
    private final By inputPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='message error']");

    private final By hyperlinkLoginPage = By.linkText("login");
    private final By hyperlinkConfirmationPage = By.linkText("here");

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
