package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By createAnAccountLink = By.xpath("//a[@href='/Account/Register.cshtml' and text()='create an account']");

    private WebElement getCreateAnAccountLink() {
        return Driver.webDriver.findElement(createAnAccountLink);
    }

    public void goToCreateAnAccountLink() {
        getCreateAnAccountLink().click();
    }


}
