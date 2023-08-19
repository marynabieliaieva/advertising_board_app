package app.advertising_board.pages.components;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class NumberInputForm {
    ElementsCollection createAdFormPredefinedValuesFields = $$(By.xpath("//input[@class='form-control' and @type='number']"));
}
