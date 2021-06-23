package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    private final By inputEmail = By.id("email");
    private final By btnSend = By.xpath("//input[@type='submit']");

    private WebElement getInputEmail() {
        return Driver.getDriver().findElement(inputEmail);
    }

    private WebElement getBtnSend() {
        return Driver.getDriver().findElement(btnSend);
    }

    public void requestResetPassword(String email) {
        getInputEmail().sendKeys(email);
        getBtnSend().click();
    }

}
