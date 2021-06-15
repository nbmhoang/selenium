package page;

import static common.Driver.webDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By createAnAccountLink = By.linkText("create an account");

    private WebElement getCreateAnAccountLink() {
        return webDriver.findElement(createAnAccountLink);
    }

    public void goToCreateAnAccountLink() {
        getCreateAnAccountLink().click();
    }

}
