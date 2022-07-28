package tests.gson;

import com.google.gson.Gson;
import test_data.models.LoginCred;
import tests.authen.LoginTestWithDataProvider;

public class TestGSON {

    public static void main(String[] args) {
        LoginCred loginCred = new LoginCred("teo@sth.com", "12345678");

        // Convert from Object data to json
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCred));

        // Convert from JSON to Object data
        String loginCredJSONData = "{\"email\" : \"password\" : \"\"}";

    }
}
