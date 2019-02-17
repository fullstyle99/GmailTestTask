package util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyWebDriver {
    //WebDriver object
    private static WebDriver driverInstance = null;

    //WebDriverWait object
    private static WebDriverWait wait = null;

    //Log object
    private static final Logger LOGGER = LogManager.getLogger(MyWebDriver.class);

    //Constructor
    private MyWebDriver() {
        driverInstance = getChromeDriverInstance();
        driverInstance = getFirefoxDriverInstance();
        wait = getWebDriverWaitInstance();
    }

    //Init methods
    public static WebDriver getChromeDriverInstance() {
        LOGGER.info("WebDriver: Initializing of the ChromeDriver ...");
        if (driverInstance==null) {
            driverInstance = new ChromeDriver();
            driverInstance.manage().window().maximize();
            driverInstance.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            LOGGER.info("WebDriver: SUCCESS: ChromeDriver initialized!");
        }
        return driverInstance;
    }

    public static WebDriver getFirefoxDriverInstance() {
        LOGGER.info("WebDriver: Initializing of the FirefoxDriver ...");
        if (driverInstance==null) {
            driverInstance = new FirefoxDriver();
            driverInstance.manage().window().maximize();
            driverInstance.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            LOGGER.info("WebDriver: SUCCESS: FirefoxDriver initialized!");
        }
        return driverInstance;
    }

    public static WebDriverWait getWebDriverWaitInstance() {
        LOGGER.info("WebDriver: Initializing of the WebDriverWait...");
        if (wait==null) {
            wait = new WebDriverWait(driverInstance, 30000);
            LOGGER.info("WebDriver: SUCCESS: WebDriverWait initialized!");
        }
        return wait;
    }

    //Force close
    public static void close() {
        LOGGER.info("WebDriver: Closing connection...");
        if (driverInstance!=null) {
            driverInstance.quit();
            driverInstance = null;
        }
        else LOGGER.info("WebDriver: Connection terminated!");
    }
}
