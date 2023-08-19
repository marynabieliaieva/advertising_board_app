package app.advertising_board.pages;

import app.advertising_board.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    SelenideElement loginLink = $(".header-wow-sticky-auth");
    SelenideElement cookiesCloseButton = $(By.xpath("//div[@class='block-cookies']/span[@class='btn-custom btn-color-blue']"));
    SelenideElement createNewAdButton = $(By.xpath("//a[@class='header-wow-sticky-add']"));
    SelenideElement userAvatarIcon = $(".mini-avatar-img");
    SelenideElement loginButton = $(".header-wow-sticky-auth");
    SelenideElement favoritesIcon = $(By.xpath("//*[contains(@class, 'toolbar-link-favorites')]"));
    SelenideElement messagesIcon = $(".toolbar-link-title-icon-box");

    @Step("Click Login Button")
    public LoginPage clickLoginButton(){
        loginLink.click();
        return new LoginPage();
    }

    public HomePage verifyUserLogged(){

        SoftAssertions softly = new SoftAssertions();

        userAvatarIcon.shouldBe(Condition.visible);
        softly.assertThat(loginButton.is(Condition.visible))
                .as("Login button should not be visible")
                .isFalse();
        softly.assertThat(favoritesIcon.is(Condition.visible))
                .as("Favorites icon should be visible")
                .isTrue();
        softly.assertThat(messagesIcon.is(Condition.visible))
                .as("Messages icon should be visible")
                .isTrue();

        softly.assertAll();
        return this;
    }

    public HomePage closeCookiesWindow(){
        cookiesCloseButton.click();
        cookiesCloseButton.shouldNotBe(Condition.visible);
        return this;
    }

    public NewAdPage createNewAd() throws IOException {
        createNewAdButton.click();
        return new NewAdPage();
    }

}
