package com.slib.bd.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DsPortfolioToRiskDTO {
    private Long dsId;
    private Long id;
    private String accessCode;
    private Long idOrigin;
    private Integer version;
    private String uniqueId;
    private Long riskUnitId;
    private String portfolioType;
    private String portfolioName;
    private String algorithm;
    private boolean portfolioExcluded;
    private LocalDate insertDate;
    private LocalDateTime insertDateTime;
    private String lcn;

    public Long getDsId() {
        return dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public Long getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(Long idOrigin) {
        this.idOrigin = idOrigin;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getRiskUnitId() {
        return riskUnitId;
    }

    public void setRiskUnitId(Long riskUnitId) {
        this.riskUnitId = riskUnitId;
    }

    public String getPortfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType) {
        this.portfolioType = portfolioType;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public boolean isPortfolioExcluded() {
        return portfolioExcluded;
    }

    public void setPortfolioExcluded(boolean portfolioExcluded) {
        this.portfolioExcluded = portfolioExcluded;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public String getLcn() {
        return lcn;
    }

    public void setLcn(String lcn) {
        this.lcn = lcn;
    }
}