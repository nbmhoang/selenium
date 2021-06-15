package page;

import static common.Driver.webDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    private final By inputCurrentPassword = By.id("currentPassword");
    private final By inputNewPassword = By.id("newPassword");
    private final By inputConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='message error']");
    private final By validationErrorMessage = By.xpath("//label[@class='validation-error']");

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

    public boolean changePassword(String currentPassword, String newPassword, String confirmPassword) {
        getInputCurrentPassword().sendKeys(currentPassword);
        getInputNewPassword().sendKeys(newPassword);
        getInputConfirmPassword().sendKeys(confirmPassword);
        getBtnChangePassword().click();
        return webDriver.findElements(errorMessage).size() == 0;
    }

}
