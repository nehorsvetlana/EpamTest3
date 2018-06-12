package pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import pages.JDIHomePage;
import pages.JDIMetalsAndColorsPage;
import pages.LoginForm;
import ru.yandex.qatools.allure.annotations.Step;


@JSite("https://epam.github.io/JDI/")
public class EpamWeb extends WebSite {

    public static JDIHomePage homePage;
    public static LoginForm loginForm;
    public static JDIMetalsAndColorsPage metalsAndColors;


    @JFindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step("Login in")
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }


}
