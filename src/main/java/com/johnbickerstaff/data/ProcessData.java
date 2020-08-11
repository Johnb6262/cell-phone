package com.johnbickerstaff.data;

import com.johnbickerstaff.model.Detail;
import com.johnbickerstaff.model.Header;
import com.johnbickerstaff.model.MonthObject;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John Bickerstaff
 * 10/08/2020
 */
public class ProcessData {
    private Map<Integer, Detail> detailMap = new HashMap<>();
    private Header header = new Header();



    public void processCellPhoneByMonth(String year, String[] line) {

        //TODO: Key off year and only take lines that have the right year per the instructions
        if(wrongYear(line, year)) {
            return;
        }

        int month = getMonth(line[1]);
        Integer detailKey = Integer.parseInt(line[0]);
        Detail tempDetail = null;
        MonthObject tempMonthObject = null;
        Integer additionalMinutes = null;
        Double additionalData = null;

        if(detailMap.containsKey(detailKey)) {
            /*
            The id has been added, we need to pull out the month
            and see if it's been added to the hashmap inside of "Header"
            if not, it gets added, if it has been added, we need to add
            to the amount of minutes and data already there (in the MonthObject)
             */

            // if(the current month exist in Header.getMonthMap)
            tempDetail = detailMap.get(detailKey);

            if(tempDetail != null && tempDetail.getMonthMap().containsKey(month)) {
                //this is additional data for that month and must be added to existing values
                tempMonthObject = tempDetail.getMonthMap().get(month);
                additionalMinutes = (Integer.parseInt(line[2]));
                additionalData = (Double.parseDouble(line[3]));
                //add to temp month object
                tempMonthObject.addToMinutes(additionalMinutes);
                tempMonthObject.addToData(additionalData);
            } else {// it doesn't exist yet so add it
                tempMonthObject = new MonthObject();
                additionalMinutes = (Integer.parseInt(line[2]));
                additionalData = (Double.parseDouble(line[3]));
                //add to temp month object
                tempMonthObject.addToMinutes(additionalMinutes);
                tempMonthObject.addToData(additionalData);
                //add tempMonthObject to ...??????
                detailMap.get(detailKey).getMonthMap().put(month, tempMonthObject);
            }

        } else { //The ID has not been added yet
            //create the new header object and set the ID
            Detail detail = new Detail();
            detail.setId(Integer.parseInt(line[0]));
            //create monthObject and add minutes and data
            MonthObject monthObject = new MonthObject();
            monthObject.setMinutesTotal(Integer.parseInt(line[2]));
            monthObject.setDataTotal(Double.parseDouble(line[3]));
            detail.getMonthMap().put(month, monthObject);
            detailMap.put(Integer.parseInt(line[0]), detail);
        }

        //Finally - run the line through Header to add numbers for totals
        header.addToMinutesTotal(Double.parseDouble(line[2]));
        header.addToDataTotal(Double.parseDouble(line[3]));
    }

    public void processCellPhoneFile(String[] line) {
        //add # of phones into header per line
        header.addOneToNumberOfPhones();
        Integer key = Integer.parseInt(line[0]);
        // Using ID as key: Put Name, model, purchase date into Detail objects per line
        if(detailMap.containsKey(key)) {
        //if(detailMap.containsKey(line[0])) {
            detailMap.get(key).setName(line[1]);
            detailMap.get(key).setPurchaseDate(line[2]);
            detailMap.get(key).setModel(line[3]);

        }
    }





    //// Helper methods

    private boolean wrongYear(String[] line, String year) {
        //TODO: Finish Me!
        return false;
    }

    private int getMonth(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date result = null;
        try {
            result = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(result);
        int month = cal.get(Calendar.MONTH);
        return month;
    }

    public Map<Integer, Detail> getDetailMap() {
        return detailMap;
    }

    public void setDetailMap(Map<Integer, Detail> detailMap) {
        this.detailMap = detailMap;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
