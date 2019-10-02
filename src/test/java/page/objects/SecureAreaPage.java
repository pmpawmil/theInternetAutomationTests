package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class SecureAreaPage extends BasePage {

    @FindBy(css = "a.button.secondary.radius")
    private WebElement logoutButton;

    private final String successMessageLocator = "div.flash.success";

    @Step("Click on logout button")
    public LoginPage clickOnLogoutButton() {
        WaitForElement.waitUntilElementIsClickable(logoutButton);
        logoutButton.click();
        log().info("Clicked on logout button");
        return new LoginPage();
    }

    @Step("Assert that success message is displayed")
    public SecureAreaPage assertThatSuccessMessageIsDisplayed() {
        log().info("Checking if message is displayed");
        WebElement successMessage = DriverManager.getWebDriver().findElement(By.cssSelector(successMessageLocator));
        WaitForElement.waitUntilElementIsVisible(successMessage);
        AssertWebElement.assertThat(successMessage).isDisplayed();
        return this;
    }

}
