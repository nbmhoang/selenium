package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;


public class Driver {

    public static WebDriver webDriver;

    private static void initDefault() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

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
                case "edge": {
                    System.setProperty("webdriver.edge.driver", absolutePath);
                    webDriver = new EdgeDriver();
                    break;
                }
                default: {
                    System.out.println("Using default driver");
                    initDefault();
                }
            }
        } else {
            initDefault();
        }
    }

}
