package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    private By inputCurrentPassword = By.id("currentPassword");
    private By inputNewPassword = By.id("newPassword");
    private By inputConfirmPassword = By.id("confirmPassword");
    private By btnChangePassword = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//p[@class='message error']");
    private By validationErrorMessage = By.xpath("//label[@class='validation-error']");

    protected WebElement getInputCurrentPassword() {
        return Driver.webDriver.findElement(inputCurrentPassword);
    }

    protected WebElement getInputNewPassword() {
        return Driver.webDriver.findElement(inputNewPassword);
    }

    protected WebElement getInputConfirmPassword() {
        return Driver.webDriver.findElement(inputConfirmPassword);
    }

    protected WebElement getBtnChangePassword() {
        return Driver.webDriver.findElement(btnChangePassword);
    }

    protected WebElement getErrorMessage() {
        return Driver.webDriver.findElement(errorMessage);
    }

    public boolean changePassword(String currentPassword, String newPassword, String confirmPassword) {
        getInputCurrentPassword().sendKeys(currentPassword);
        getInputNewPassword().sendKeys(newPassword);
        getInputConfirmPassword().sendKeys(confirmPassword);
        getBtnChangePassword().click();
        return !getErrorMessage().isDisplayed();
    }

}
