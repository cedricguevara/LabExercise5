package com.guevara.labexercise5;

public class Data {private int logo;
    private String comName, country, ceo, industry,description;

    public Data(int logo, String comName, String country, String ceoName, String industry, String description) {
        this.logo = logo;
        this.comName = comName;
        this.country = country;
        this.ceo = ceoName;
        this.industry = industry;
        this.description = description;
    }

    public int getLogo() {
        return logo;
    }

    public String getComName() {
        return comName;
    }

    public String getCountry() {
        return country;
    }

    public String getCeoName() {
        return ceo;
    }

    public String getIndustry() {
        return industry;
    }

    public String getDescription() {
        return description;
    }
}
