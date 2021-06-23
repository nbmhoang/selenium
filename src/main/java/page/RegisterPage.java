package page;

import common.Driver;
import common.Utils;
import data.RegisterInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        return Driver.getDriver().findElement(inputEmail);
    }

    private WebElement getInputPassword() {
        return Driver.getDriver().findElement(inputPassword);
    }

    private WebElement getInputConfirmPassword() {
        return Driver.getDriver().findElement(inputConfirmPassword);
    }

    private WebElement getInputPID() {
        return Driver.getDriver().findElement(inputPID);
    }

    private WebElement getBtnRegister() {
        return Driver.getDriver().findElement(btnRegister);
    }

    private WebElement getErrorMessage() {
        return Driver.getDriver().findElement(errorMessage);
    }

    private WebElement getLblEmailValidationError() {
        return Driver.getDriver().findElement(lblEmailValidationError);
    }

    private WebElement getLblPasswordValidationError() {
        return Driver.getDriver().findElement(lblPasswordValidationError);
    }

    private WebElement getLblConfirmPasswordValidationError() {
        return Driver.getDriver().findElement(lblConfirmPasswordValidationError);
    }

    private WebElement getLblPIDValidationError() {
        return Driver.getDriver().findElement(lblPIDValidationError);
    }

    private WebElement getHyperlinkLogin() {
        return Driver.getDriver().findElement(hyperlinkLoginPage);
    }

    private WebElement getHyperlinkConfirmation() {
        return Driver.getDriver().findElement(hyperlinkConfirmationPage);
    }

    private WebElement getResponseMessage() {
        return Driver.getDriver().findElement(responseMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return Driver.getDriver().findElements(errorMessage).size() != 0;
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
        return Driver.getDriver().findElements(lblEmailValidationError).size() != 0;
    }

    public String getEmailValidationError() {
        return getLblEmailValidationError().getText();
    }

    public boolean isPasswordValidationErrorDisplayed() {
        return Driver.getDriver().findElements(lblPasswordValidationError).size() != 0;
    }

    public String getPasswordValidationError() {
        return getLblPasswordValidationError().getText();
    }

    public boolean isConfirmPasswordValidationErrorDisplayed() {
        return Driver.getDriver().findElements(lblConfirmPasswordValidationError).size() != 0;
    }

    public String getConfirmPasswordValidationError() {
        return getLblConfirmPasswordValidationError().getText();
    }

    public boolean isPIDValidationErrorDisplayed() {
        return Driver.getDriver().findElements(lblPIDValidationError).size() != 0;
    }

    public String getPIDValidationError() {
        return getLblPIDValidationError().getText();
    }

    public LoginPage clickHyperlinkLogin() {
        getHyperlinkLogin().click();
        return new LoginPage();
    }



}
