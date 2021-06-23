package page;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public static final String HEADER = "Welcome to Safe Railway";

    private final By createAnAccountLink = By.linkText("create an account");

    private WebElement getCreateAnAccountLink() {
        return Driver.getDriver().findElement(createAnAccountLink);
    }

    public void goToCreateAnAccountLink() {
        getCreateAnAccountLink().click();
    }

}
