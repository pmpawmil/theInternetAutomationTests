package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
            driver = WebDriverEventListenerRegistrar.registerWebDriverEventListener(driver);
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }

}