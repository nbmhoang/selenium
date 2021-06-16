package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;


public class Driver {

    public static WebDriver webDriver;

    public static void initDriver(String browserName, String path) {
        if (Objects.nonNull(browserName) && Objects.nonNull(path)) {
            String absolutePath = System.getProperty("user.dir") + path;
            switch (browserName) {
                case "chrome": {
                    System.setProperty("webdriver.chrome.driver", absolutePath);
                    webDriver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    System.setProperty("webdriver.gecko.driver", absolutePath);
                    webDriver = new FirefoxDriver();
                    break;
                }
                case "ie": {
                    System.setProperty("webdriver.ie.driver", absolutePath);
                    webDriver = new InternetExplorerDriver();
                    break;
                }
                default: {
                    System.out.println("Invalid browser");
                }
            }
        } else {
            System.out.println("Invalid config");
        }

    }

}
