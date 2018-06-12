package pages;


import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.testng.Assert;
import entities.Data;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;


@JPage(url = "metals-colors.html", title = "Metal and Colors")
public class JDIMetalsAndColorsPage extends WebPage {
    @FindBy(css = ".radio")//xpath = "//p[@class='radio']"
    public RadioButtons radioButton;
    @JDropdown(
            jroot = @JFindBy(id = "colors"),
            jlist = @JFindBy(tagName = "a")
    )
    public IDropDown color;
    @JFindBy(css = "#elements-checklist | .checkbox label")
    public CheckList element;
    @JComboBox(root = @FindBy(css = ".salad"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public ComboBox vegetable;
    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "a"))
    public IComboBox metals;
    @JFindBy(id = "submit-button")
    public Button submit;

    //Fill form Metals & Colors by data below:
    @Step("Fill up data")
    public void MetalsDColorsForm(Data datas) {
        for (int i = 0; i < datas.summary.length; i++)
            radioButton.select(String.valueOf(datas.summary[i]));
        for (int i = 0; i < datas.elements.length; i++)
            element.select(datas.elements[i]);
        color.select(datas.color);
        metals.select(datas.metals);
        for (int i = 0; i < datas.vegetables.length; i++)
            vegetable.select(datas.vegetables[i]);
        submit.click();
        for (int i = 0; i < datas.elements.length; i++)
            element.select(datas.elements[i]);
        for (int i = 0; i < datas.vegetables.length; i++)
            vegetable.select(datas.vegetables[i]);
    }

    @JFindBy(css = ".results")
    public TextList resultList;

    //Result sections should contains data  below:
    @Attachment(value = "Validate dates ")
    @Step("Results")
    public String validate(Data datas) {
        int summ = 0;
        for (int i = 0; i < datas.summary.length; i++)
            summ += datas.summary[i];
        String element = new String();
        for (int i = 0; i < datas.elements.length; i++) {
            element += datas.elements[i];
            if (i <= datas.elements.length - 2)
                element += ", ";
        }
        String vegetable = new String();
        for (int i = 0; i < datas.vegetables.length; i++) {
            vegetable += datas.vegetables[i];
            if (i <= datas.vegetables.length - 2)
                vegetable += ", ";
        }
        String mess = new String(
                "Summary: " + Integer.toString(summ) +
                        "\nElements: " + element +
                        "\nColor: " + datas.color +
                        "\nMetal: " + datas.metals +
                        "\nVegetables: " + vegetable);
        Assert.contains(resultList.getValue(), mess);
        return mess;
    }
}