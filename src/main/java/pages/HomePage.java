package pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

//homePage
public class HomePage {
    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    SelenideElement loginField;

    @FindBy(css = "#Password")
    SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    @FindBy(css = ".main-title")
    SelenideElement mainTitle;

    @FindBy(css = ".main-txt.text-center")
    SelenideElement mainText;

    @FindBy(css = ".dropdown-toggle")
    SelenideElement serviceDrop;

    @FindBy(css = "ul.dropdown-menu")
    SelenideElement menuHead;

    @FindBy(css = "ul.sub")
    SelenideElement menuLeft;

    @FindBy(css = ".sub-menu>a")
    SelenideElement serviceDropLeft;

    @FindBy(css = " .dropdown-menu a[href='page8.htm']")
    SelenideElement differentElements;

    @FindBy(css = " .dropdown-menu a[href='page4.htm']")
    SelenideElement datePage;


    public HomePage() {
        Selenide.page(this);
    }

    @Step("Open JDI test site")
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    @Step("Perform login")
    public void login(String login, String password) {
        profilePhoto.scrollTo();
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.scrollTo();
        submit.click();
    }

    //Assert User name in the left-top side of screen that user is loggined
    @Step("Check user on home page")
    public void checkUserLogIn(String userName) {
        profilePhoto.shouldHave(exactText(userName));
    }

    //Check interface on Home page, it contains all needed elements.
    @Step("Check 4 texts on home page")
    public void check4Text() {
        //Sizzle
        $(".benefit-txt:contains(\"To include\")").scrollTo();
        $(".benefit-txt:contains(\"To include\")").shouldBe(exist);
        $(".benefit-txt:contains(\"flexible and\")").should(exist);
        $(".benefit-txt:contains(\"multiplatform\")").should(exist);
        $(".benefit-txt:contains(\"about 20 internal\")").should(exist);
    }

    @Step("Check 2 main text on home page")
    public void check2Text(String textMain, String titleMain) {
        //mainTitle.shouldBe(visible);
        mainTitle.shouldHave(exactText(titleMain));
        mainText.shouldHave(text(textMain));
    }

    @Step("Check 4 images on home page")
    public void picture() {
        $(".icons-benefit.icon-practise").should(exist);
        $(".icons-benefit.icon-custom").should(exist);
        $(".icons-benefit.icon-multi").should(exist);
        $(".icons-benefit.icon-base").should(exist);
    }

    //Click on "Service" subcategory in the header and check that drop down contains options
    @Step("Check header menu on home page")
    /*public void existDropHeader(String dropText1, String dropText2, String dropText3, String dropText4, String dropText5, String dropText6) {
        serviceDrop.click();
        $(".dropdown-menu a[href='page3.htm']").shouldHave(text(dropText1));
        $(".dropdown-menu a[href='page4.htm']").shouldHave(text(dropText2));
        $(".dropdown-menu a[href='page5.htm']").shouldHave(text(dropText3));
        $(".dropdown-menu a[href='page6.htm']").shouldHave(text(dropText4));
        $(".dropdown-menu a[href='page7.htm']").shouldHave(text(dropText5));
        $(".dropdown-menu a[href='page8.htm']").shouldHave(text(dropText6));
    }
*/
    public void existDropHeader(String[] menuTexts) {
        serviceDrop.click();
        for (String menuText : menuTexts)
            menuHead.shouldHave(text(menuText));
    }

    //Click on Service subcategory in the left section and check that drop down contains options
    @Step("Check left menu on home page")
    public void existDropLeft(String[] menuTexts) {
        serviceDropLeft.click();
        for (String menuText : menuTexts)
            menuLeft.shouldHave(text(menuText));
    }

    /*public void existDropLeft(String dropText1, String dropText2, String dropText3, String dropText4, String dropText5, String dropText6) {
        serviceDropLeft.click();
        $(".sub-menu a[href='page3.htm']").shouldHave(text(dropText1));
        $(".sub-menu a[href='page4.htm']").shouldHave(text(dropText2));
        $(".sub-menu a[href='page5.htm']").shouldHave(text(dropText3));
        $(".sub-menu a[href='page6.htm']").shouldHave(text(dropText4));
        $(".sub-menu a[href='page7.htm']").shouldHave(text(dropText5));
        $(".sub-menu a[href='page8.htm']").shouldHave(text(dropText6));
    }
*/
    //Open through the header menu Service -> Different Elements Page
    @Step("Open different elements page")
    public void openPageElement() {
        serviceDrop.click();
        differentElements.click();
    }

    @Step("Open Dates page")
    public void openPageDates() {
        serviceDrop.click();
        datePage.click();
        
    }
}
