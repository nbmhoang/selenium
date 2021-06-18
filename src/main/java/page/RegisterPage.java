package page;

import common.Utils;
import data.RegisterInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class RegisterPage extends BasePage {

    public static final String HEADER = "Create account";

    private final By inputEmail = By.id("email");
    private final By inputPassword = By.id("password");
    private final By inputConfirmPassword = By.id("confirmPassword");
    private final By inputPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='message error']");
    private final By responseMessage = By.xpath("//div[@id='content']/p");
    private final By lblEmailValidationError = By.xpath("//label[@for='email' and @class='validation-error']");
    private final By lblPasswordValidationError = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblConfirmPasswordValidationError = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
    private final By lblPIDValidationError = By.xpath("//label[@for='pid' and @class='validation-error']");
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

    private WebElement getLblEmailValidationError() {
        return webDriver.findElement(lblEmailValidationError);
    }

    private WebElement getLblPasswordValidationError() {
        return webDriver.findElement(lblPasswordValidationError);
    }

    private WebElement getLblConfirmPasswordValidationError() {
        return webDriver.findElement(lblConfirmPasswordValidationError);
    }

    private WebElement getLblPIDValidationError() {
        return webDriver.findElement(lblPIDValidationError);
    }

    private WebElement getHyperlinkLogin() {
        return webDriver.findElement(hyperlinkLoginPage);
    }

    private WebElement getHyperlinkConfirmation() {
        return webDriver.findElement(hyperlinkConfirmationPage);
    }

    private WebElement getResponseMessage() {
        return webDriver.findElement(responseMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return webDriver.findElements(errorMessage).size() != 0;
    }

    public String getErrorMessageContent() {
        return getErrorMessage().getText();
    }

    public String getResponseMessageContent() {
        return getResponseMessage().getText();
    }

    public void register(RegisterInfo registerInfo) {
        Utils.scrollToEnd();

        getInputEmail().sendKeys(registerInfo.getEmail());
        getInputPassword().sendKeys(registerInfo.getPassword());
        getInputConfirmPassword().sendKeys(registerInfo.getConfirmPassword());
        getInputPID().sendKeys(registerInfo.getPID());
        getBtnRegister().click();
    }

    public boolean isEmailValidationErrorDisplayed() {
        return webDriver.findElements(lblEmailValidationError).size() != 0;
    }

    public String getEmailValidationError() {
        return getLblEmailValidationError().getText();
    }

    public boolean isPasswordValidationErrorDisplayed() {
        return webDriver.findElements(lblPasswordValidationError).size() != 0;
    }

    public String getPasswordValidationError() {
        return getLblPasswordValidationError().getText();
    }

    public boolean isConfirmPasswordValidationErrorDisplayed() {
        return webDriver.findElements(lblConfirmPasswordValidationError).size() != 0;
    }

    public String getConfirmPasswordValidationError() {
        return getLblConfirmPasswordValidationError().getText();
    }

    public boolean isPIDValidationErrorDisplayed() {
        return webDriver.findElements(lblPIDValidationError).size() != 0;
    }

    public String getPIDValidationError() {
        return getLblPIDValidationError().getText();
    }

    public LoginPage clickHyperlinkLogin() {
        getHyperlinkLogin().click();
        return new LoginPage();
    }



}
