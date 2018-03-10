package page.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractTestPage;
import ru.yandex.qatools.allure.annotations.Step;
import user.User;

import java.util.function.Function;

public class AuthPage extends AbstractTestPage {

    @FindBy(css = "form[method='POST']")
    private WebElement authForm;
    @FindBy(css = "*[name='username']")
    private WebElement userName;
    @FindBy(css = "*[name='password']")
    private WebElement password;
    @FindBy(css = "*[name='Check']")
    private WebElement submitButton;

    public AuthPage(WebDriver driver) {
        super(driver, "http://test.levx.ru/check.php");
    }

    @Override
    public AuthPage open(Function<WebDriver, Boolean>... conditions) {
        super.open(conditions);
        return this;
    }

    @Step("Авторизоваться пользователем")
    public void authBy(User user) {
        fillUserName(user.getName());
        fillPassword(user.getPassword());
        fillPassword();
    }

    @Step("Ввести логин {0}")
    public void fillUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    @Step("Ввести пароль {0}")
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step("Нажать кнопку \"Отправить\"")
    public void fillPassword() {
        submitButton.click();
    }

    @Override
    public boolean isLoaded() {
        return super.isLoaded() && authForm.isDisplayed();
    }
}
