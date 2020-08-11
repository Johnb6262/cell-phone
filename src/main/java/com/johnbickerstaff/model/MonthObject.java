package com.johnbickerstaff.model;

import java.math.BigInteger;

/**
 * @author John Bickerstaff
 * 10/08/2020
 */
public class MonthObject {

    private Integer minutesTotal = 0;
    private Double dataTotal = 0D;

    public Integer getMinutesTotal() {
        return minutesTotal;
    }

    public void setMinutesTotal(Integer minutesTotal) {
        this.minutesTotal = minutesTotal;
    }

    public Double getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(Double dataTotal) {
        this.dataTotal = dataTotal;
    }

    public void addToMinutes(Integer moreMinutes) {
        this.minutesTotal += moreMinutes;
    }

    public void addToData(Double moreData) {
        this.dataTotal += moreData;
    }
}
