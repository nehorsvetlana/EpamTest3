package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static java.lang.Math.abs;

//test case2
public class DataPage {
    /**
     * Ползунки
     */
    @FindBy(css = ".ui-slider-handle")
    ElementsCollection slider;

    //@FindBy(css= ".ui-slider")
    @FindBy(css = ".ui-slider")
    private WebElement sliderTrack;

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private WebElement sliderLeft;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private WebElement sliderRight;

    public DataPage() {
        Selenide.page(this);
    }

    /**
     * Получить шаг в слайдбаре
     */

    public Integer getStep() {
        return sliderTrack.getSize().width;
    }

    /**
     * Получить текущую позицию слайдера
     *
     * @return значение от 0-го до 100-ти
     */
    public Integer getCurrentPositionLeft() {
        // Позицию можно получить по значению атрибута left
        // getCssValue("left") возвращает абсолютное значение в px,
        Integer sliderCenterPx = Integer.parseInt(sliderLeft.getText());
        return sliderCenterPx;
    }

    public Integer getCurrentPositionRight() {
        // Позицию можно получить по значению атрибута left
        // getCssValue("left") возвращает абсолютное значение в px,
        //Integer sliderCenterPx = Integer.parseInt(sliderRight.getCssValue("left")
        //         .replaceAll("px", "")) + sliderRight.getSize().width / 100;
        Integer sliderCenterPx = Integer.parseInt(sliderRight.getText());
        return sliderCenterPx;
    }

    //движение слайдера
    public void setDragAndDropRight(int leftSlider, int rightSlider, Actions actions) {

        //правое налево
        if (getCurrentPositionRight() > rightSlider) {
            Integer xOffsetR = (rightSlider - 1 - getCurrentPositionRight()) * getStep() / 100;
            actions.dragAndDropBy(sliderRight, xOffsetR, 0).build().perform();
        }
        //правое направо
        else {
            Integer xOffsetR = (getCurrentPositionRight() + rightSlider - 1) * getStep() / 100;
            actions.dragAndDropBy(sliderRight, xOffsetR, 0).build().perform();
        }
    }

    public void setDragAndDropLeft(int leftSlider, int rightSlider, Actions actions) {
        if (getCurrentPositionLeft() >= leftSlider) {
            Integer xOffset = (leftSlider - 1 - getCurrentPositionLeft()) * getStep() / 100;
            actions.dragAndDropBy(sliderLeft, xOffset, 0).build().perform();
        }
        //левое направо
        else {
            Integer xOffset = (leftSlider - getCurrentPositionLeft()) * getStep() / 100;
            actions.dragAndDropBy(sliderLeft, xOffset, 0).build().perform();
        }
    }

    public void setDragAndDrop(int leftSlider, int rightSlider) {
        slider.shouldHaveSize(2);//2 ползунка
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        if ((getCurrentPositionLeft() == getCurrentPositionRight()) && (leftSlider < rightSlider)) {
            setDragAndDropLeft(leftSlider, rightSlider, actions);
            setDragAndDropRight(leftSlider, rightSlider, actions);
        } else {
            setDragAndDropRight(leftSlider, rightSlider, actions);
            setDragAndDropLeft(leftSlider, rightSlider, actions);
        }
        int weight = (getCurrentPositionRight() - getCurrentPositionLeft());
        slider.last().shouldHave(text(Integer.toString(rightSlider)));
        slider.first().shouldHave(text(Integer.toString(leftSlider)));
    }
}
