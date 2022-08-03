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


}
