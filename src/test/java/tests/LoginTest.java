package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class LoginTest extends TestBase {

    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            "and check if success message is displayed")
    public void asUserLoginUsingValidLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("tomsmith")
                .typeIntoPasswordField("SuperSecretPassword!")
                .clickOnLoginButtonWithCorrectDataProvided()
                .assertThatSuccessMessageIsDisplayed();
    }

    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            "and check if unsuccessful message is displayed")
    public void asUserLoginUsingInvalidLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("wrongLogin")
                .typeIntoPasswordField("wrongPassword")
                .clickOnLoginButtonWithWrongDataProvided()
                .assertThatUnsuccessfulMessageIsDisplayed();
    }

}
