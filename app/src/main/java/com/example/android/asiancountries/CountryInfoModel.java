package com.example.android.asiancountries;

import java.util.ArrayList;
import java.util.List;

public class CountryInfoModel {

    private String country_flag;
    private String country_name;
    private String country_capital;
    private String country_region;
    private String country_sub_region;
    private long country_population;
//    private String country_borders;
//    private String country_languages;
    List<String> country_borders = new ArrayList<String>();
//    List<String> country_languages = new ArrayList<String>();
    public CountryInfoModel(String country_flag, String country_name, String country_capital, String country_region, String country_sub_region, long country_population, List<String> country_borders ) {
        this.country_flag = country_flag;
        this.country_name = country_name;
        this.country_capital = country_capital;
        this.country_region = country_region;
        this.country_sub_region = country_sub_region;
        this.country_population = country_population;
        this.country_borders = country_borders;
//        this.country_borders = country_borders;
//        this.country_languages = country_languages;
    }

    public String getCountry_flag() {
        return country_flag;
    }

    public void setCountry_flag(String country_flag) {
        this.country_flag = country_flag;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_capital() {
        return country_capital;
    }

    public void setCountry_capital(String country_capital) {
        this.country_capital = country_capital;
    }

    public String getCountry_region() {
        return country_region;
    }

    public void setCountry_region(String country_region) {
        this.country_region = country_region;
    }

    public String getCountry_sub_region() {
        return country_sub_region;
    }

    public void setCountry_sub_region(String country_sub_region) {
        this.country_sub_region = country_sub_region;
    }

    public long getCountry_population() {
        return country_population;
    }

    public void setCountry_population(long country_population) {
        this.country_population = country_population;
    }

    public List<String> getCountry_borders() {
        return country_borders;
    }

    public void setCountry_borders(List<String> country_borders) {
        this.country_borders = country_borders;
    }
//    public List<String> getCountry_borders() {
//        return country_borders;
//    }
//
//    public void setCountry_borders(List<String> country_borders) {
//        this.country_borders = country_borders;
//    }
//
//    public List<String> getCountry_languages() {
//        return country_languages;
//    }
//
//    public void setCountry_languages(List<String> country_languages) {
//        this.country_languages = country_languages;
//    }
}
