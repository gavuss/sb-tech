import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import user.BlackListName;
import user.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Alexander Silaev on 07.03.2018.
 */
public class BaseTest {

    public WebDriver driver;
    public static final long WEBDRIVER_TIMEOUT = Long.parseLong(System.getProperty("webdriver.timeout", "2"));
    public List<String> list;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WEBDRIVER_TIMEOUT, TimeUnit.SECONDS);
        list = new BlackListName().getBlackList();
    }

    @Test
    public void sendRequest() {
        User user = new User().generateName(5, list).generatePass(5);
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        given().when().get("http://test.levx.ru/rest.php?uname=" + user.getName() + "&pass=" + user.getPassword() + "").then().statusCode(200);
    }


}
