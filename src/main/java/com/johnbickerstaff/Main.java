package com.johnbickerstaff;

import com.johnbickerstaff.data.FileReader;
import com.johnbickerstaff.data.ProcessData;

/**
 * @author John Bickerstaff
 * 10/08/2020
 */
public class Main {

    public static void main(String[] args) {
        ProcessData processData = new ProcessData();

        FileReader fileReader = new FileReader();

        fileReader.loadUsageByMonthFile(processData,"2017",
                "src/main/resources/CellPhoneUsageByMonth.csv");

        fileReader.loadCellPhoneFile(processData,
                "src/main/resources/CellPhone.csv");

        System.out.println("done");
    }
}
