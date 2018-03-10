package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.BlackListName.getBlackList;

public class BaseTest {

    public WebDriver driver;
    public static final long WEBDRIVER_TIMEOUT = Long.parseLong(System.getProperty("webdriver.timeout", "30"));
    public List<String> list;
    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\blacklist.txt";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WEBDRIVER_TIMEOUT, TimeUnit.SECONDS);
        list = getBlackList(filePath);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}