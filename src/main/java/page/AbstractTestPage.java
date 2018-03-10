package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.function.Function;

import static utils.BaseTest.WEBDRIVER_TIMEOUT;

public class AbstractTestPage {

    private WebDriver driver;
    private String url;

    public AbstractTestPage(WebDriver driver, String url) {
        this(driver);
        this.url = url;
    }

    public AbstractTestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public AbstractTestPage open(Function<WebDriver, Boolean>... conditions) {
        return openByUrl(url, conditions);
    }

    @Step("Открыть страницу по ссылке \"{0}\"")
    public AbstractTestPage openByUrl(String url, Function<WebDriver, Boolean>... conditions) {
        if (url == null) {
            throw new IllegalArgumentException("Url не может быть null");
        }
        driver.get(url);
        waitUntilIsDisplayed(conditions);
        return this;
    }

    public void waitUntilIsDisplayed(Function<WebDriver, Boolean>... conditions) {

        Wait<WebDriver> wait = new WebDriverWait(driver, WEBDRIVER_TIMEOUT);
        wait.until(driver -> isLoaded());

        for (Function<WebDriver, Boolean> condition : conditions) {
            wait.until(booleanSupplier -> condition.apply(driver));
        }
    }

    public boolean isLoaded() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return "complete".equals(jsExecutor.executeScript("return document.readyState"));
    }
}
