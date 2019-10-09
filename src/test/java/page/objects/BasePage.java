package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private Logger logger = LogManager.getLogger(this.getClass().getName());
    // part of highlighting element
    JavascriptExecutor js;

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
        // part of highlighting element
        js = (JavascriptExecutor) DriverManager.getWebDriver();
    }

    protected Logger log() {
        return logger;
    }

    // part of highlighting element
    public void highlightElement(WebElement element, int duration) throws InterruptedException {
        String original_style = element.getAttribute("style");

        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (duration > 0) {
            Thread.sleep(duration * 1000);
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    element,
                    "style",
                    original_style);
        }
    }
}
