package page;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Alexander Silaev on 07.03.2018.
 */
public class AuthPage {

    private WebDriver driver;
    private String url;

    public AuthPage(WebDriver driver, String url) {
        this(driver);
        this.url = url;
    }

    public AuthPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populate(this, driver);
    }
}
