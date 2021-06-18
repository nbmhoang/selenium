package page;

import static common.Driver.webDriver;

import common.Utis;
import data.ChangePasswordInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    public static final String HEADER = "Change password";

    private final By inputCurrentPassword = By.id("currentPassword");
    private final By inputNewPassword = By.id("newPassword");
    private final By inputConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='message error']");
    private final By validationErrorMessage = By.xpath("//label[@class='validation-error']");
    private final By successMessage = By.xpath("//p[@class='message success']");

    protected WebElement getInputCurrentPassword() {
        return webDriver.findElement(inputCurrentPassword);
    }

    protected WebElement getInputNewPassword() {
        return webDriver.findElement(inputNewPassword);
    }

    protected WebElement getInputConfirmPassword() {
        return webDriver.findElement(inputConfirmPassword);
    }

    protected WebElement getBtnChangePassword() {
        return webDriver.findElement(btnChangePassword);
    }

    protected WebElement getErrorMessage() {
        return webDriver.findElement(errorMessage);
    }

    private WebElement getSuccessMessage() {
        return webDriver.findElement(successMessage);
    }

    public String getSuccessMessageContent() {
        return getSuccessMessage().getText();
    }

    public boolean changePassword(ChangePasswordInfo data) {
        Utis.scrollToEnd();

        getInputCurrentPassword().sendKeys(data.getCurrentPassword());
        getInputNewPassword().sendKeys(data.getNewPassword());
        getInputConfirmPassword().sendKeys(data.getConfirmPassword());
        getBtnChangePassword().click();
        return webDriver.findElements(errorMessage).size() == 0;
    }

}
