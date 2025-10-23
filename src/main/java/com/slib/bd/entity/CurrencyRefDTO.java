package com.slib.bd.entity;

import java.time.LocalTime;

public class CurrencyRefDTO {
    private String currencyCode;
    private int decimalNumber;
    private String label;
    private Integer version;
    private String idOrigin;
    private String accessCode;
    private LocalTime cutOff;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(String idOrigin) {
        this.idOrigin = idOrigin;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public LocalTime getCutOff() {
        return cutOff;
    }

    public void setCutOff(LocalTime cutOff) {
        this.cutOff = cutOff;
    }
}
