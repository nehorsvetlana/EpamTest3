import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactPage;
import pages.DataPage;
import pages.DifferentPage;
import pages.HomePage;

public class EpamSelenid {
    static public HomePage homePage;
    static public DifferentPage diffPage;
    static public ContactPage contactPage;
    static public DataPage dataPage;
/*
    public static void init(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);;
        contactPage=PageFactory.initElements(driver, ContactPage.class);
    }
    */
    public static void init() {
        homePage = new HomePage();
        diffPage = new DifferentPage();
        contactPage = new ContactPage();
        dataPage = new DataPage();

    }
}
