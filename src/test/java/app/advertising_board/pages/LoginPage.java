package app.advertising_board.pages;

import app.advertising_board.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    SelenideElement userNameField = $("[name='user_login']"),
    passwordField = $("[name='user_pass']"),
    loginConfirmButton = $(By.xpath("//button[text()='Login']")),
    loginErrorMessage = $(By.xpath("//div[@class='auth-block-right']//*[text()='Invalid username and/or password!']"));

    @Step("Set User Name {userName}")
    public LoginPage setUserName(){
        userNameField.setValue(System.getProperty("USERNAME"));
        return this;
    }

    @Step("Set User Name {userName}")
    public LoginPage setInvalidUserName(String incorrectUserName){
        userNameField.setValue(incorrectUserName);
        return this;
    }

    @Step("Set Password}")
    public LoginPage setValidPassword(){
        passwordField.setValue(System.getProperty("PASSWORD"));
        return this;
    }

    @Step("Set Password {password}")
    public LoginPage setInvalidPassword(String password){
        passwordField.setValue(password);
        return this;
    }

    @Step("Click Login Button")
    public LoginPage confirmLogin(){
        loginConfirmButton.click();
        return this;
    }

    @Step("Login With Valid Credentials {ConfigLoader.getInstance().getUserName()}")
    public HomePage loginWithValidCredentials(){
        setUserName();
        setValidPassword();
        confirmLogin();
        return new HomePage();
    }

    @Step("Login With Valid Credentials {ConfigLoader.getInstance().incorrectUserName()}")
    public LoginPage loginWithInValidCredentials(String userName, String password){
        setInvalidUserName(userName);
        setInvalidPassword(password);
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
