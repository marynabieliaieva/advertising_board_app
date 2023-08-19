package app.advertising_board.base;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.assertj.core.api.SoftAssertions;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public SoftAssertions softAssertions = new SoftAssertions();
    public SelenideElement getElementByText(String text){
        return $(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
    }
}
