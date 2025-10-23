package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DsClientEntityDTO {
    private Long dsId;
    private Long id;
    private String accessCode;
    private BigDecimal creditLine;
    private boolean isRealTimeOexFeed;
    private String name;
    private Long idOrigin;
    private Integer version;
    private String referenceCurrencyRefId;
    private Long superClientId;
    private String uniqueId;
    private boolean simulation;
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

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }

    public boolean isRealTimeOexFeed() {
        return isRealTimeOexFeed;
    }

    public void setRealTimeOexFeed(boolean realTimeOexFeed) {
        isRealTimeOexFeed = realTimeOexFeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getReferenceCurrencyRefId() {
        return referenceCurrencyRefId;
    }

    public void setReferenceCurrencyRefId(String referenceCurrencyRefId) {
        this.referenceCurrencyRefId = referenceCurrencyRefId;
    }

    public Long getSuperClientId() {
        return superClientId;
    }

    public void setSuperClientId(Long superClientId) {
        this.superClientId = superClientId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public boolean isSimulation() {
        return simulation;
    }

    public void setSimulation(boolean simulation) {
        this.simulation = simulation;
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