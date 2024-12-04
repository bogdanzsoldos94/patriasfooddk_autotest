package data;

import org.testng.annotations.DataProvider;

public class LoginDP {

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//          username, password, browser
                {"tradeandfacts", "testez1122", "edge"},
                {"tradeandfacts", "testez1122", "chrome"},
                {"camel", "camelpassword", "chrome"},
        };
    }


};
