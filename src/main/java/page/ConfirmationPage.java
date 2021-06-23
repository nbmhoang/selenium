package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ConfirmationPage extends BasePage {

    private final By inputConfirmationCode = By.id("confirmationCode");
    private final By btnConfirm = By.xpath("//input[@type='submit']");

    private WebElement getInputConfirmationCode() {
        return Driver.getDriver().findElement(inputConfirmationCode);
    }

    private WebElement getBtnConfirm() {
        return Driver.getDriver().findElement(btnConfirm);
    }

    public void confirmAccount(String confirmCode) {
        getInputConfirmationCode().sendKeys(confirmCode);
        getBtnConfirm().click();
    }

}
