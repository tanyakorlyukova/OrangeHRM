package tests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new String[][] {
                {"", "", "Username cannot be empty"},
                {"invalid", "admin123", "Invalid credentials"},
                {"Admin", "invalid", "Invalid credentials"},
                {"invalid", "invalid", "Invalid credentials"},
                {"@#$%&^~", "@#$%&^~", "Invalid credentials"}
        };
    }

    @DataProvider(name = "addValidUserData")
    public static Object[][] addValidUserdata() {
        return new String[][] {
                {"John Smith", "asfrfdrsy", "password", "password"},  //all fields - valid
                {"John Smith", "atfsldrsy", "", ""},   //password is not required
                {"John Smith", "ahfsf", "password", "password"}  //5 characters in Username (at least 5)
        };
    }

    @DataProvider(name = "addInvalidUserData")
    public static Object[][] addInvalidUserdata() {
        return new String[][] {
                {"", "", "", ""},   //empty
                {"d", "d", "d", "d"},   //invalid
                {"John Smith", "hanna", "password", "otherpassword"},   //different password
                {"John Smith", "Admin", "password", "password"},   //user Admin exist
                {"John Smith", "page", "password", "password"},  //4 characters in Username (at least 5)
                {"notexistemployee", "exist", "password", "password"},  //employee does not exist
                {"John Smith", "laaaaaary", "sssssss", "sssssss"}   //7 characters in Password (at least 8)
        };
    }
}
