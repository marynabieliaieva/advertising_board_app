package app.advertising_board.pages;

import app.advertising_board.base.BasePage;
import app.advertising_board.objects.AdData;
import app.advertising_board.pages.components.Categories;
import app.advertising_board.constants.CategoryType;
import app.advertising_board.pages.components.SelectBoxForm;
import app.advertising_board.utils.JacksonUtils;
import app.advertising_board.utils.RandomUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewAdPage extends BasePage {
    Categories categoriesComponent = new Categories();
    SelectBoxForm selectBoxForm = new SelectBoxForm();
    AdData adData = JacksonUtils.deserializeJson("adData.json", AdData.class);

    SelenideElement nameTextField = $(By.xpath("//input[@name='title']"));
    SelenideElement descriptionTextField = $(".ads-create-textarea");
    SelenideElement publishAdButton = $(".ads-create-publish.btn-color-blue");
    SelenideElement cityTextField = $(".ads-create-input.action-input-search-city");
    SelenideElement citySelectedValueConfirmation = $(By.xpath("//div[@class='item-city']"));
    SelenideElement priceTextField = $(By.xpath("//input[@name='price']"));
    SelenideElement addressTextField = $("input#searchMapAddress");
    SelenideElement photoUpload = $(By.xpath("//input[@type='file']"));
    ElementsCollection createAdFormSelectBoxes = $$(By.xpath("//*[@data-name='Not chosen']"));
    ElementsCollection createAdFormSelectBoxValues = $$(".uni-select-list");

    SelenideElement subcategoryHeader = $(".ads-create-subcategory");
    ElementsCollection createAdElements = $$(".ads-create-subtitle");

    public NewAdPage() throws IOException {
    }

    public NewAdPage setRandomValueOf(CategoryType categoryType){
        List<String> categoryNamesList;
        if (categoryType == CategoryType.CATEGORY) {
            categoryNamesList = categoriesComponent.getCategoryNames(categoriesComponent.categories);
        } else {
            categoryNamesList = categoriesComponent.getCategoryNames(categoriesComponent.subCategories);
        }
        String categoryLinkName = RandomUtils.getRandomItemFromArray(categoryNamesList);
        SelenideElement categoryLinkNameElement = getElementByText(categoryLinkName);
        $(categoryLinkNameElement).click();
        return this;
    }

    public NewAdPage verifyCategorySelected(){
        $(subcategoryHeader).shouldBe(Condition.visible);
        return this;
    }

    public NewAdPage verifySubCategorySelected(){
        $$(createAdElements).get(0).shouldBe(Condition.visible);
        return this;
    }

    public NewAdPage setAdDescription(String description){
        descriptionTextField.setValue(description);
        return this;
    }

    public NewAdPage setAdTitle(String title){
        nameTextField.setValue(title);
        return this;
    }

    public NewAdPage UploadFile(){
        File file = new File(JacksonUtils.class.getClassLoader().getResource(adData.getFileName()).getPath());
        photoUpload.uploadFile(file);
        return this;
    }

    public NewAdPage setAdCity(String city){
        cityTextField.setValue(city);
        citySelectedValueConfirmation.click();
        return this;
    }

    public NewAdPage setAdAddress(String address){
        addressTextField.setValue(address);
        return this;
    }

    public ExistingAdPage submitNewAdd(){
        publishAdButton.click();
        return new ExistingAdPage();
    }

    public ExistingAdPage createRealEstateAd(){
        setAdDescription(adData.getDescription());
        selectBoxForm.fillOutSelectBoxes(createAdFormSelectBoxes);
        setAdCity(adData.getCity());
        setAdAddress(adData.getAddress());
        UploadFile();
        submitNewAdd();
        return new ExistingAdPage();
    }

}
