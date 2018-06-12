import com.epam.jdi.uitests.web.selenium.driver.ScreenshotMaker;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import entities.Data;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.EpamWeb;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static pages.EpamWeb.*;

@Listeners//(epam.allure.allure.class)
@Features({"Testing Website"})
@Stories({"Home work 8"})
public class JDITest extends TestNGBase {
    @DataProvider
    public static Object[] dataProvider() throws IOException {
        Map<String, Data> datas;

        FileReader fileReader = new FileReader("C:\\test.json");
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, Data>>() {
        }.getType();

        datas = new Gson().fromJson(jsonReader, type);

        return datas.values().toArray();
    }


    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        WebSite.init(EpamWeb.class);
        logger.info("Before Class");
        //driver
        driverFactory.getDriver();
        //open
        homePage.open();
        //Login on JDI site as User
        login();
        //Open Metals & Colors page by Header menu
        metalsAndColors.open();
        metalsAndColors.checkOpened();
        metalsAndColors.vegetable.select("Vegetables");
    }

    @Attachment(type = "image/png")
    public byte[] scr() throws IOException {
        String screenLocation = ScreenshotMaker.takeScreen();
        BufferedImage bufImage = ImageIO.read(new File(screenLocation));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufImage, "png", bos);
        byte[] data = bos.toByteArray();
        return data;
    }

    @Test(dataProvider = "dataProvider")
    public void testWithData(Data data) {
        metalsAndColors.MetalsDColorsForm(data);
        metalsAndColors.validate(data);
        try {
            scr();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
