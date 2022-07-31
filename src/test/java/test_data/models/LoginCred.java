package test_data.models;

import org.testng.annotations.DataProvider;
import tests.authen.LoginTestWithDataProvider;

    public class LoginCred {
        String username;
        String password;

        public LoginCred(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "LoginCred{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }


    @DataProvider
    public LoginCred[] loginCredData(){
        LoginCred data1 = new LoginCred("teo@", "12345678");
        LoginCred data2 = new LoginCred("teo@sth.com", "12345678");
        LoginCred data3 = new LoginCred("teo@sth.com", "1234568");
        return new LoginCred[]{data1, data2, data3};
    }
}
