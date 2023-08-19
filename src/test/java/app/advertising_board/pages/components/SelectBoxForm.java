package app.advertising_board.pages.components;

import app.advertising_board.base.BasePage;
import app.advertising_board.utils.RandomUtils;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectBoxForm {
    BasePage basePage = new BasePage();
    Categories categories = new Categories();



    public void fillOutSelectBoxes(ElementsCollection elements){
        for(int i = 1; i < elements.size()+1; i++) {
            elements.get(i).click();
            SelenideElement selectBoxValuesLinkNameElement = basePage.getElementByText(RandomUtils.getRandomItemFromArray(categories.getCategoryNames(elements)));
            $(selectBoxValuesLinkNameElement).click();
        }
    }


}
