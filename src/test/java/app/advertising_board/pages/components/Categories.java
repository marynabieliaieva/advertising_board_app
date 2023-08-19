package app.advertising_board.pages.components;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$;

public class Categories {
    public ElementsCollection categories = $$(By.xpath("//span[@class='ads-create-main-category-name']"));
    public ElementsCollection subCategories = $$(By.xpath("//div[@class='ads-create-subcategory-list']//span"));

    public List<String> getCategoryNames(ElementsCollection elements){
        List<String> categoryNamesList = new ArrayList<>();
        for (SelenideElement category : elements){
            categoryNamesList.add(category.getText());
        }
        return categoryNamesList;
    }


}
