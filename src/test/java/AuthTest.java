import org.junit.Assert;
import org.junit.Test;
import page.auth.AuthPage;
import page.res.ResPage;
import ru.yandex.qatools.allure.annotations.Step;
import user.User;
import utils.BaseTest;

import static utils.NetHelper.sendUserCredentials;

public class AuthTest extends BaseTest {

    @Test
    public void sendRequest() {
        User user = new User().generateName(5, list).generatePass(5);
        sendUserCredentials(user);
        AuthPage authPage = new AuthPage(driver).open();
        authPage.authBy(user);
        ResPage resPage = new ResPage(driver);
        assertSessionResult("username found", resPage);
    }

    @Step("Проверить, результат авторизации = {0}")
    public void assertSessionResult(String expected, ResPage page) {
        String actualResult = page.getResultMessage();
        Assert.assertEquals("Ожидаемый результат авторизации - " + expected + "\n" +
                        "Фактическое результат авторизации - " + actualResult,
                actualResult, expected);
    }

/*
    Есть некий сервис, который умеет сохранять имена пользователя и пароли. Сохранение делается через API вызов.
    Далее для проверки сохранения нужно через веб форму проверить сохранились ли имя пользователя и пароль.

    API часть доступна по адресу test.levx.ru/rest.php?uname=username&pass=password
    где
    username - сохраняемое имя пользователя
    password - пароль

    Ограничения:
    * нельзя сохранять одно имя пользователя 2 раза
    * есть запрещенный список имен пользователя (например root)
    * имя пользователя не может быть пустым

    Во всех этих случаях возвращается ошибка, иначе успех.
    После сорханения нужно открыть форму по адресу
    http://test.levx.ru/check.php
    ввести те же логин и пароль, и нажать кнопку.
    Произойдет переход на страницу http://test.levx.ru/res.php где и будет виден результат.

    Нужен jUnit тест, который сохраняет произвольное имя пользователя и пароль, и проверяет через форму, что введенные има пользователя и пароль сохранились успешно.*/

}
