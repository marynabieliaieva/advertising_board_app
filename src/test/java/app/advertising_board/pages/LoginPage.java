package app.advertising_board.pages;

import app.advertising_board.base.BasePage;
import app.advertising_board.utils.ConfigLoader;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.assertj.core.api.SoftAssertions;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    SelenideElement userNameField = $("[name='user_login']"),
    passwordField = $("[name='user_pass']"),
    loginConfirmButton = $(By.xpath("//button[text()='Login']")),
    loginErrorMessage = $(By.xpath("//div[@class='auth-block-right']//*[text()='Invalid username and/or password!']"));

    @Step("Set User Name {userName}")
    public LoginPage setUserName(String userName){
        userNameField.setValue(userName);
        return this;
    }

    @Step("Set Password {password}")
    public LoginPage setPassword(String password){
        passwordField.setValue(password);
        return this;
    }

    @Step("Click Login Button")
    public LoginPage confirmLogin(){
        loginConfirmButton.click();
        return this;
    }

    @Step("Login With Valid Credentials {ConfigLoader.getInstance().getUserName()}")
    public HomePage loginWithValidCredentials(String userName, String password){
        setUserName(userName);
        setPassword(password);
        confirmLogin();
        return new HomePage();
    }

    @Step("Login With Valid Credentials {ConfigLoader.getInstance().incorrectUserName()}")
    public LoginPage loginWithInValidCredentials(String userName, String password){
        setUserName(userName);
        setPassword(password);
        confirmLogin();
        return this;
    }

    @Step("Verify That User Is Not Logged")
    public LoginPage verifyUserIsNotLogged() {
        softAssertions.assertThat(loginErrorMessage.is(Condition.visible))
                .as("User avatar icon should be visible")
                .isTrue();
        softAssertions.assertThat(userNameField.is(Condition.visible))
                .as("Login button should not be visible")
                .isTrue();
        softAssertions.assertThat(userNameField.is(Condition.visible))
                .as("User avatar icon should be visible")
                .isTrue();
        return this;
    }
}
