package dataprovider;

import com.opencsv.CSVReader;

import java.io.*;

public class CSVFileReader {

    public String[][] getCSVData(String filename, int row, int col) {
        String[][] data = new String[row][col];
        try {
            CSVReader csvreader = new CSVReader(new FileReader(filename));
            for (int i = 0; i < row; i++) {
                String[] line = csvreader.readNext();
                for (int j = 0; j < line.length; j++) {
                    data[i][j] = line[j];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            writeData(new String[] {"notfound"}, "notfound.txt");
        } catch (IOException e) {
            e.printStackTrace();
            writeData(new String[] {"otherserror"}, "other.txt");
        }
        return data;
    }

    public void writeData(String[] data, String filename) {
        try {
            FileWriter wr = new FileWriter(filename);
            for (int i=0; i<data.length;i++) {
                wr.write(data[i]);
            }
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
