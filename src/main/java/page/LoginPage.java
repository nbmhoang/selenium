package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By inputEmail = By.xpath("//input[@id='username']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//p[@class='message error LoginForm']");

    protected WebElement getInputEmail() {
        return Driver.webDriver.findElement(inputEmail);
    }

    protected WebElement getInputPassword() {
        return Driver.webDriver.findElement(inputPassword);
    }

    protected WebElement getBtnLogin() {
        return Driver.webDriver.findElement(btnLogin);
    }

    protected WebElement getErrorMessage() {
        return Driver.webDriver.findElement(errorMessage);
    }

    public boolean login(String username, String password) {
        getInputEmail().sendKeys(username);
        getInputPassword().sendKeys(password);
        // scroll
        getBtnLogin().click();
        try {
            getErrorMessage();
            return false;
        } catch (Exception err) {
            return true;
        }
    }


}
