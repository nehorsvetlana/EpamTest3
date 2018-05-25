package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static enums.DifferentDate.CHECKBOX1;
import static enums.DifferentDate.CHECKBOX2;
import static enums.DifferentDate.RADIOB;


public class DifferentPage {
    @FindBy (css = ".dropdown-menu-login")
    SelenideElement dropdown;

    @FindBy (css = ".uui-button[value='Default Button']")
    SelenideElement defButton;

    @FindBy (css = "input[value='Button']")
    SelenideElement Button;

    @FindBy (css = "#mCSB_1_container")
    SelenideElement leftSection;

    @FindBy (css = "._mCS_2")
    SelenideElement rightSection;

    @FindBy(css = ".logs > li")
    private ElementsCollection log;

    private List<String> logList;


    public DifferentPage() {
        Selenide.page(this);
        logList = new java.util.LinkedList<>();
    }
    public void interfaceServing(){
        //Sizzle
        $(".label-checkbox:contains('Water')").shouldBe(exist);
        $(".label-checkbox:contains('Earth')").should(exist);
        $(".label-checkbox:contains('Wind')").should(exist);
        $(".label-checkbox:contains('Fire')").should(exist);
        $(".label-radio:contains('Gold')").shouldBe(exist);
        $(".label-radio:contains('Silver')").should(exist);
        $(".label-radio:contains('Bronze')").should(exist);
        $(".label-radio:contains('Selen')").should(exist);
        dropdown.should(exist);
        defButton.should(exist);
        Button.should(exist);
        leftSection.should(exist);
        rightSection.should(exist);
    }
    public void selectCheckBox(){
        //http://selenide.org/javadoc/3.5/com/codeborne/selenide/SelenideElement.html
        $("label:contains('Water')").setSelected(true);
        $(".label-checkbox:contains('Water') input").shouldBe(checked);
        logList.add(CHECKBOX1.toString());
        $(".label-checkbox:contains('Wind')").setSelected(true);
        $(".label-checkbox:contains('Wind') input").shouldBe(checked);
        logList.add(CHECKBOX2.toString());
    }
    public void selectRadios() {
        $(".label-radio:contains('Selen')").setSelected(true);
        $(".label-radio:contains('Selen') input").shouldBe(checked);
        logList.add(RADIOB.toString());
    }
    public void selectDropdown(String option){
        $(".colors .uui-form-element").selectOption(option);
        $(".colors .uui-form-element").getSelectedOption().shouldBe(enabled);
        logList.add(option);
    }
    public void checkLogsSelected(){
        log.shouldHave(texts(logList));//проверка на содержание части текста
    }
    public void selectUn(String option){
        logList.remove(RADIOB.toString());
        logList.remove(option);
        logList.remove(CHECKBOX1.toString());
        logList.remove(CHECKBOX2.toString());

    }
}
