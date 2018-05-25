
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Configuration.SelectorMode.Sizzle;
import static enums.DifferentDate.DROPDOWN;
import static enums.DifferentDate.RADIOB;
import static enums.HomeDate.*;
import java.util.concurrent.TimeUnit;


//http://ru.selenide.org/documentation.html

//Create a new test in a new Java class, specify test name accordingly checking functionality
public class MySelenideTest {
    private static WebDriver driver;

    @BeforeClass
    public static void BeforeTest() {
        //1 Create a new test
        // TODO this should be specified via pom.xml
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Светлана\\IdeaProjects\\EpamHomeWork3\\drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
       // driver.manage().window().maximize();//размер окна
        Configuration.browser = "chrome";
        // !TODO nice exploration ! +1 point to Telematics !
        Configuration.selectorMode = Sizzle; //Теперь в Selenide можно использовать CSS3 селекторы для поиска элементов!
        EpamSelenid.init();
    }

    // TODO Update .gitignore !!
    // TODO remove binaries/reports from repo
    // TODO where is manual steps in comments ??

    // TODO unfortunately, this test failed
    //    TextsMismatch
    //    Actual: [14:08:45 Wind: condition changed to true, 14:08:45 Water: condition changed to true]
    //    Expected: [Water, Wind]
    //    Collection: .logs > li
    //
    //    Screenshot: file:/C:/Users/Dmitry_Lebedev1/Documents/spbstu_18/nehorsvetlana/build/reports/tests/1527246532122.0.png
    //    Page source: file:/C:/Users/Dmitry_Lebedev1/Documents/spbstu_18/nehorsvetlana/build/reports/tests/1527246532122.0.html
    //    Timeout: 6 s.
    //    at com.codeborne.selenide.collections.ExactTexts.fail(ExactTexts.java:53)
    //    at com.codeborne.selenide.ElementsCollection.waitUntil(ElementsCollection.java:98)
    //    at com.codeborne.selenide.ElementsCollection.should(ElementsCollection.java:57)
    //    at com.codeborne.selenide.ElementsCollection.shouldHave(ElementsCollection.java:48)
    //    at pages.DifferentPage.checkLogsSelected(DifferentPage.java:81)
    //    at MySelenideTest.Case1(MySelenideTest.java:59)
    // !TODO
    @Test
    public void Case1() {
        EpamSelenid.homePage.open();
        EpamSelenid.homePage.login(LOGIN.toString(), PASSWORD.toString());
        EpamSelenid.homePage.checkUserLogIn(USER_NAME.toString());
        EpamSelenid.homePage.check4Text();
        EpamSelenid.homePage.check2Text(HOME_PAGE_TEXT.toString(), HOME_PAGE_TITLE.toString());
        EpamSelenid.homePage.picture();
        // TODO oh my good, my FulHD TV cant display this line at once !!
        // TODO code convention !
        EpamSelenid.homePage.existDropHeader(HOME_PAGE_DROP_HEADER_MENU_T1.toString(), HOME_PAGE_DROP_HEADER_MENU_T2.toString(), HOME_PAGE_DROP_HEADER_MENU_T3.toString(), HOME_PAGE_DROP_HEADER_MENU_T4.toString(), HOME_PAGE_DROP_HEADER_MENU_T5.toString(), HOME_PAGE_DROP_HEADER_MENU_T6.toString());
        EpamSelenid.homePage.existDropLeft(HOME_PAGE_DROP_HEADER_MENU_T1.toString(), HOME_PAGE_DROP_HEADER_MENU_T2.toString(), HOME_PAGE_DROP_HEADER_MENU_T3.toString(), HOME_PAGE_DROP_HEADER_MENU_T4.toString(), HOME_PAGE_DROP_HEADER_MENU_T5.toString(), HOME_PAGE_DROP_HEADER_MENU_T6.toString());
        EpamSelenid.homePage.openPageElement();
        EpamSelenid.diffPage.interfaceServing();
        EpamSelenid.diffPage.selectCheckBox();
        EpamSelenid.diffPage.selectRadios();
        EpamSelenid.diffPage.selectDropdown(DROPDOWN.toString());
        //EpamSelenid.diffPage.checkLogsSelected();
        EpamSelenid.diffPage.selectUn(DROPDOWN.toString());
        Selenide.refresh();//обновление страниц
        EpamSelenid.diffPage.selectCheckBox();
        EpamSelenid.diffPage.checkLogsSelected();

    }
}

