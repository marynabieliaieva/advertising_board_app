package app.advertising_board.tests.ui;

import app.advertising_board.base.TestBase;
import app.advertising_board.utils.ConfigLoader;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("regression")
public class LoginFunctionality extends TestBase {

    @Test
    @DisplayName("Verify that user is able to login with valid credentials")
    public void loginWithValidCredentials() throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open(ConfigLoader.getInstance().getBaseUrl());
        });

        homePage.clickLoginButton()
                .loginWithValidCredentials(ConfigLoader.getInstance().getUserName(), ConfigLoader.getInstance().getPassword())
                .verifyUserLogged();
    }

    //TODO Implement test with Data Driven
    @MethodSource("app.advertising_board.utils.DataProviders#credentialsDataProvider")
    @ParameterizedTest (name = "Verify that user is not able to login with invalid credentials: {0} and {1}")
    public void loginWithInvalidCredentials(String userName, String password) throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open(ConfigLoader.getInstance().getBaseUrl());
        });
        homePage.clickLoginButton()
                .loginWithInValidCredentials(userName, password)
                .verifyUserIsNotLogged();
    }
}
