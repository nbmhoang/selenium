package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Driver.webDriver;

public class ConfirmationPage extends BasePage {

    private By inputConfirmationCode = By.id("confirmationCode");
    private By btnConfirm = By.xpath("//input[@type='submit']");

    private WebElement getInputConfirmationCode() {
        return webDriver.findElement(inputConfirmationCode);
    }

    private WebElement getBtnConfirm() {
        return webDriver.findElement(btnConfirm);
    }

    public void confirmAccount(String confirmCode) {
        getInputConfirmationCode().sendKeys(confirmCode);
        getBtnConfirm().click();
    }

}
