package utils;

import com.jayway.restassured.RestAssured;
import user.User;

public class NetHelper {

    public static void sendUserCredentials(User user) {
        RestAssured.given().when().get("http://test.levx.ru/rest.php?uname=" + user.getName() + "&pass=" + user.getPassword()).then().statusCode(200);
    }
}
