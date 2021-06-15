package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class ForgotPasswordPage extends BasePage {

    private By inputEmail = By.id("email");
    private By btnSend = By.xpath("//input[@type='submit']");

    private WebElement getInputEmail() {
        return webDriver.findElement(inputEmail);
    }

    private WebElement getBtnSend() {
        return webDriver.findElement(btnSend);
    }

    public void requestResetPassword(String email) {
        getInputEmail().sendKeys(email);
        getBtnSend().click();
    }

}
