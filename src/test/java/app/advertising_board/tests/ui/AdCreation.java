package app.advertising_board.tests.ui;

import app.advertising_board.base.TestBase;
import app.advertising_board.constants.CategoryType;
import app.advertising_board.utils.ConfigLoader;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("regression")
public class AdCreation extends TestBase {
    @Test
    @DisplayName("Verify that user is able to add new ad")
    public void addAd() throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open(ConfigLoader.getInstance().getBaseUrl());
        });
        homePage.clickLoginButton()
                .loginWithValidCredentials(ConfigLoader.getInstance().getUserName(), ConfigLoader.getInstance().getPassword())
                .verifyUserLogged()
                .closeCookiesWindow()
                .createNewAd()
                .setRandomValueOf(CategoryType.CATEGORY)
                .verifyCategorySelected()
                .setRandomValueOf(CategoryType.SUBCATEGORY)
                .verifySubCategorySelected()
                .createRealEstateAd();

    }
}
