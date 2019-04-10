package dataprovider;

import org.testng.annotations.DataProvider;


public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\loginData.csv", 5, 3);
    }

    @DataProvider(name = "addValidUserData")
    public static Object[][] addValidUserdata() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\validUserData.csv", 3, 4);
    }

    @DataProvider(name = "addInvalidUserData")
    public static Object[][] addInvalidUserdata() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\invalidUserData.csv", 7, 4);
    }
}
