package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DsAccountDTO {

    private BigDecimal dsId;
    private BigDecimal id;
    private String accessCode;
    private String name;
    private BigDecimal idOrigin;
    private Long version;
    private String connectorParamId;
    private BigDecimal accountTypeId;
    private BigDecimal clientEntityId;
    private String uniqueId;
    private String cp;
    private String tp;
    private String type;
    private String account;
    private LocalDate insertDate;
    private LocalDateTime insertDateTime;

    public BigDecimal getDsId() {
        return dsId;
    }

    public void setDsId(BigDecimal dsId) {
        this.dsId = dsId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(BigDecimal idOrigin) {
        this.idOrigin = idOrigin;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getConnectorParamId() {
        return connectorParamId;
    }

    public void setConnectorParamId(String connectorParamId) {
        this.connectorParamId = connectorParamId;
    }

    public BigDecimal getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(BigDecimal accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public BigDecimal getClientEntityId() {
        return clientEntityId;
    }

    public void setClientEntityId(BigDecimal clientEntityId) {
        this.clientEntityId = clientEntityId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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