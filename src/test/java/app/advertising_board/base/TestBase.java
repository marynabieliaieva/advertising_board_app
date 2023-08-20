package app.advertising_board.base;

import app.advertising_board.pages.HomePage;
import app.advertising_board.utils.ConfigLoader;
import com.codeborne.selenide.Configuration;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    public HomePage homePage = new HomePage();

    @BeforeEach
    public void beforeAll(){
        Configuration.baseUrl = ConfigLoader.getInstance().getBaseUrl();
        Configuration.startMaximized = Boolean.parseBoolean(ConfigLoader.getInstance().getstartMaximized());
        Configuration.browser = ConfigLoader.getInstance().getbrowser();
        Configuration.timeout = Long.parseLong(ConfigLoader.getInstance().getTimeout());
    }

    @AfterEach
    public void afterEach(){
        closeWebDriver();
    }

}
