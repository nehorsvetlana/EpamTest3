package pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


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


    @FindBy(css = ".sub-menu>a")
    SelenideElement serviceDropLeft;

    @FindBy(css = " .dropdown-menu a[href='page8.htm']")
    SelenideElement differentElements;

    @FindBy(css = " .dropdown-menu a[href='page4.htm']")
    SelenideElement datePage;


    public HomePage() {
    Selenide.page(this);
    }

    //@Step("Open JDI test site")
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }
    //Perform login
    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }
    //Assert User name in the left-top side of screen that user is loggined
    public void checkUserLogIn(String userName) {
        profilePhoto.shouldHave(exactText(userName));
    }
    //Check interface on Home page, it contains all needed elements.
    public void check4Text(){
        //Sizzle
        $(".benefit-txt:contains(\"To include\")").shouldBe(exist);
        $(".benefit-txt:contains(\"flexible and\")").should(exist);
        $(".benefit-txt:contains(\"multiplatform\")").should(exist);
        $(".benefit-txt:contains(\"about 20 internal\")").should(exist);
    }
    public void check2Text(String textMain,String titleMain) {
        //mainTitle.shouldBe(visible);
        mainTitle.shouldHave(exactText(titleMain));
        mainText.shouldHave(text(textMain));
    }
    public void picture(){
        $(".icons-benefit.icon-practise").should(exist);
        $(".icons-benefit.icon-custom").should(exist);
        $(".icons-benefit.icon-multi").should(exist);
        $(".icons-benefit.icon-base").should(exist);
    }
    //Click on "Service" subcategory in the header and check that drop down contains options
    public void existDropHeader(String dropText1,String dropText2,String dropText3,String dropText4,String dropText5,String dropText6) {
        serviceDrop.click();
        $(".dropdown-menu a[href='page3.htm']").shouldHave(text(dropText1));
        $(".dropdown-menu a[href='page4.htm']").shouldHave(text(dropText2));
        $(".dropdown-menu a[href='page5.htm']").shouldHave(text(dropText3));
        $(".dropdown-menu a[href='page6.htm']").shouldHave(text(dropText4));
        $(".dropdown-menu a[href='page7.htm']").shouldHave(text(dropText5));
        $(".dropdown-menu a[href='page8.htm']").shouldHave(text(dropText6));
    }
    //Click on Service subcategory in the left section and check that drop down contains options
    public void existDropLeft(String dropText1,String dropText2,String dropText3,String dropText4,String dropText5,String dropText6) {
        serviceDropLeft.click();
        $(".sub-menu a[href='page3.htm']").shouldHave(text(dropText1));
        $(".sub-menu a[href='page4.htm']").shouldHave(text(dropText2));
        $(".sub-menu a[href='page5.htm']").shouldHave(text(dropText3));
        $(".sub-menu a[href='page6.htm']").shouldHave(text(dropText4));
        $(".sub-menu a[href='page7.htm']").shouldHave(text(dropText5));
        $(".sub-menu a[href='page8.htm']").shouldHave(text(dropText6));
    }
    //Open through the header menu Service -> Different Elements Page
    public void openPageElement(){
        serviceDrop.click();
        differentElements.click();
    }
    public void openPageDates(){
        serviceDrop.click();
        datePage.click();
    }
}
