package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.Arrays;
import java.util.Set;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button")
    private WebElement loginButton;

    private final String unsuccessfulMessageLocator = "div.flash.error";

    @Step("Type into user name field {username}")
    public LoginPage typeIntoUsernameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Typed into user name field {}", username);
        return this;
    }

    @Step("Type into password field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        log().info("Typed into password field {}", password);
        return this;
    }

    @Step("Click on login button")
    public SecureAreaPage clickOnLoginButtonWithCorrectDataProvided() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        log().info("Clicked on login button");
        return new SecureAreaPage();
    }

    @Step("Click on login button")
    public LoginPage clickOnLoginButtonWithWrongDataProvided() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        log().info("Clicked on login button");
        return this;
    }

    @Step("Assert that unsuccessful message is displayed")
    public LoginPage assertThatUnsuccessfulMessageIsDisplayed() {
        log().info("Checking if message {} is displayed");
        WebElement unsuccessfulMessage = DriverManager.getWebDriver().findElement(By.cssSelector(unsuccessfulMessageLocator));
        WaitForElement.waitUntilElementIsVisible(unsuccessfulMessage);
        AssertWebElement.assertThat(unsuccessfulMessage).isDisplayed();
        return this;
    }

    // checks what type of logs can be get from a browser
    public void GetAvailableLogs() {
        Set<String> availableLogTypes = DriverManager.getWebDriver().manage().logs().getAvailableLogTypes();
        System.out.println(Arrays.toString(availableLogTypes.toArray()));
    }

}
