package com.johnbickerstaff.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author John Bickerstaff
 * 10/08/2020
 */
public class Header {

    private Date reportDate = new Date();
    private int numberOfPhones;


    private Double totalMinutes = 0D;
    private Double averageMinutes = 0D;
    private Double totalData = 0D;
    private Double averageData  = 0D;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public int getNumberOfPhones() {
        return numberOfPhones;
    }

//    public void setNumberOfPhones(int numberOfPhones) {
//        this.numberOfPhones = numberOfPhones;
//    }

    public void addOneToNumberOfPhones(){
        this.numberOfPhones++;
    }

    public Double getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(Double totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public Double getAverageMinutes() {
        //I'm aware that the report might want only from purchase date
        //but I'm declaring that out of scope for this exercise
        return averageMinutes;
    }

    public void setAverageMinutes(Double averageMinutes) {
        this.averageMinutes = averageMinutes;
    }

    public Double getTotalData() {
        return totalData;
    }

//    public void setTotalData(Integer totalData) {
//        this.totalData = totalData;
//    }

    public void addToDataTotal(Double minutesFromFile) {
        this.totalData += minutesFromFile;
        this.averageData = this.totalData / 12;
    }

    public Double getAverageData() {
        //I'm aware that the report might want only from purchase date
        //but I'm declaring that out of scope for this exercise
        return averageData / 12;
    }

//    public void setAverageData(Double averageData) {
//        this.averageData = averageData;
//    }

    public void addToMinutesTotal(Double totalFromFile) {
        this.totalMinutes += totalFromFile;
        this.averageMinutes = this.totalMinutes / 12;
    }
}
