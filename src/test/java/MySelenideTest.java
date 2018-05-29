/* Copyright (C) 2018 Svetlana Nekhoroshikh
   Telematics
   33607
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Configuration.SelectorMode.Sizzle;
import static enums.DifferentDate.*;
import static enums.HomeDate.*;

import java.util.concurrent.TimeUnit;


//http://ru.selenide.org/documentation.html

//Create a new test in a new Java class, specify test name accordingly checking functionality
public class MySelenideTest {
    private static WebDriver driver;

    @BeforeClass
    public static void BeforeTest() {
        //1 Create a new test
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Светлана\\IdeaProjects\\EpamHomeWork3\\drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        // driver.manage().window().maximize();//размер окна
        Configuration.browser = "chrome";
        Configuration.selectorMode = Sizzle; //Теперь в Selenide можно использовать CSS3 селекторы для поиска элементов!
        EpamSelenid.init();
    }

    @Test
    public void Case1() {
        //HomePage
        EpamSelenid.homePage.open();
        EpamSelenid.homePage.login(LOGIN.toString(), PASSWORD.toString());
        EpamSelenid.homePage.checkUserLogIn(USER_NAME.toString());
        EpamSelenid.homePage.check4Text();
        EpamSelenid.homePage.check2Text(HOME_PAGE_TEXT.toString(), HOME_PAGE_TITLE.toString());
        EpamSelenid.homePage.picture();
        EpamSelenid.homePage.existDropHeader(DROP_T1.toString(), DROP_T2.toString(), DROP_T3.toString(), DROP_T4.toString(), DROP_T5.toString(), DROP_T6.toString());
        EpamSelenid.homePage.existDropLeft(DROP_T1.toString(), DROP_T2.toString(), DROP_T3.toString(), DROP_T4.toString(), DROP_T5.toString(), DROP_T6.toString());
        EpamSelenid.homePage.openPageElement();
        //Different Element Page
        EpamSelenid.diffPage.interfaceServing();
        EpamSelenid.diffPage.selectCheckBox();
        EpamSelenid.diffPage.selectRadios();
        EpamSelenid.diffPage.selectDropdown(DROPDOWN.toString());
        EpamSelenid.diffPage.checkLogsSelected(CHECKBOX1.toString(), CHECKBOX2.toString(), RADIOB.toString(), DROPDOWN.toString());
        EpamSelenid.diffPage.selectUn(DROPDOWN.toString());
        Selenide.refresh();//обновление страниц
        EpamSelenid.diffPage.selectCheckBox();
        EpamSelenid.diffPage.checkLogSelected(CHECKBOX1.toString(), CHECKBOX2.toString());
    }
    /*public void Case2() {
        //HomePage
        //Open test site by URL
        EpamSelenid.homePage.open();
        //Perform login
        EpamSelenid.homePage.login(LOGIN.toString(), PASSWORD.toString());
        //Assert User name in the left-top side of screen that user is loggined
        EpamSelenid.homePage.checkUserLogIn(USER_NAME.toString());
        //Open Service -> Dates
        EpamSelenid.homePage.openPageDates();
        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        EpamSelenid.dataPage.setDragAndDrop(0,100);
        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        EpamSelenid.dataPage.setDragAndDrop(0,0);
        //Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        EpamSelenid.dataPage.setDragAndDrop(100,100);
        //Using drag-and-drop set Range sliders.
        //EpamSelenid.dataPage.setDragAndDrop(30,70);
   }*/

}

