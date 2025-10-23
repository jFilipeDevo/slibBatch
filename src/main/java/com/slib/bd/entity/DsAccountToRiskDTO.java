package com.slib.bd.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DsAccountToRiskDTO {
    private Long dsId;
    private Long id;
    private String accessCode;
    private String cashFilter;
    private Long idOrigin;
    private String securityFilter;
    private Integer version;
    private Long accountId;
    private Long riskUnitId;
    private String uniqueId;
    private String portfolioName;
    private LocalDate insertDate;
    private LocalDateTime insertDateTime;

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

    public String getCashFilter() {
        return cashFilter;
    }

    public void setCashFilter(String cashFilter) {
        this.cashFilter = cashFilter;
    }

    public Long getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(Long idOrigin) {
        this.idOrigin = idOrigin;
    }

    public String getSecurityFilter() {
        return securityFilter;
    }

    public void setSecurityFilter(String securityFilter) {
        this.securityFilter = securityFilter;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRiskUnitId() {
        return riskUnitId;
    }

    public void setRiskUnitId(Long riskUnitId) {
        this.riskUnitId = riskUnitId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
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
}