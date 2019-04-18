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

    @DataProvider(name = "addValidJobTitle")
    public static Object[][] addValidJobTitle() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\JobTitlesData\\addValidData.csv", 4, 4);
    }

    @DataProvider(name = "addInvalidJobTitle")
    public static Object[][] addInvalidJobTitle() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\JobTitlesData\\addInvalidData.csv", 4, 4);
    }

    @DataProvider(name = "editOnValidJobTitle")
    public static Object[][] editOnvalidJobTitle() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\JobTitlesData\\editOnValidData.csv", 2, 4);
    }

    @DataProvider(name = "editOnInvalidJobTitle")
    public static Object[][] editOnInvalidJobTitle() {
        CSVFileReader reader = new CSVFileReader();
        return reader.getCSVData("src\\test\\resources\\JobTitlesData\\editOnInvalidData.csv", 4, 4);
    }

    @DataProvider(name = "deleteJobTitle")
    public static Object[][] deleteJobTitle() {
        return new String[][] {
                {"1"},
                {"3"}
        };
    }
}
