
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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Светлана\\IdeaProjects\\EpamHomeWork3\\drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
       // driver.manage().window().maximize();//размер окна
        Configuration.browser = "chrome";
        Configuration.selectorMode = Sizzle; //Теперь в Selenide можно использовать CSS3 селекторы для поиска элементов!
        EpamSelenid.init();
    }

    @Test
    public void Case1() {
        EpamSelenid.homePage.open();
        EpamSelenid.homePage.login(LOGIN.toString(), PASSWORD.toString());
        EpamSelenid.homePage.checkUserLogIn(USER_NAME.toString());
        EpamSelenid.homePage.check4Text();
        EpamSelenid.homePage.check2Text(HOME_PAGE_TEXT.toString(), HOME_PAGE_TITLE.toString());
        EpamSelenid.homePage.picture();
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

