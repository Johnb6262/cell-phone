package com.johnbickerstaff.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author John Bickerstaff
 * 10/08/2020
 */
public class Detail {

    private long id;
    private String name;
    private String model;
    private String purchaseDate;

    //Map<Integer, Map<Integer, MonthObject>> monthMap = new LinkedHashMap<>(); //keyed by year
    private Map<Integer, MonthObject> monthMap = new LinkedHashMap<>(); //keyed by month

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Map<Integer, MonthObject> getMonthMap() {
        return monthMap;
    }

    public void setMonthMap(Map<Integer, MonthObject> monthMap) {
        this.monthMap = monthMap;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
