package com.johnbickerstaff.data;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author John Bickerstaff
 * 10/08/2020
 */
public class FileReader {



    public void loadUsageByMonthFile(ProcessData processData, String year, String path) {
        try {
            BufferedReader bis =
                    new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            try {
                CSVReader reader = new CSVReader(bis);
                String[] line;
                reader.readNext(); //The first line is the header

                while ((line = reader.readNext()) != null) {
                    processData.processCellPhoneByMonth(year, line);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error processing file contents: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public void loadCellPhoneFile(ProcessData processData,  String path) {
        try {
            BufferedReader bis =
                    new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            try {
                CSVReader reader = new CSVReader(bis);
                String[] line;
                reader.readNext(); //The first line is the header

                while ((line = reader.readNext()) != null) {
                    //processData.processCellPhoneByMonth(year, line);
                    processData.processCellPhoneFile(line);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error processing file contents: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
