package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SuperClientDTO {
    private Long id;
    private String accessCode;
    private BigDecimal creditLine;
    private String name;
    private Long idOrigin;
    private Integer version;
    private String referenceCurrencyRefId;
    private LocalDateTime auditEntryTs;
    private LocalDateTime auditEntryTsPrev;
    private String uniqueId;
    private LocalDateTime auditEntryTsLast;
    private LocalDateTime auditValidationTsLast;
    private String userIdLastChange;
    private boolean simulation;

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

    public LocalDateTime getAuditEntryTs() {
        return auditEntryTs;
    }

    public void setAuditEntryTs(LocalDateTime auditEntryTs) {
        this.auditEntryTs = auditEntryTs;
    }

    public LocalDateTime getAuditEntryTsPrev() {
        return auditEntryTsPrev;
    }

    public void setAuditEntryTsPrev(LocalDateTime auditEntryTsPrev) {
        this.auditEntryTsPrev = auditEntryTsPrev;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public LocalDateTime getAuditEntryTsLast() {
        return auditEntryTsLast;
    }

    public void setAuditEntryTsLast(LocalDateTime auditEntryTsLast) {
        this.auditEntryTsLast = auditEntryTsLast;
    }

    public LocalDateTime getAuditValidationTsLast() {
        return auditValidationTsLast;
    }

    public void setAuditValidationTsLast(LocalDateTime auditValidationTsLast) {
        this.auditValidationTsLast = auditValidationTsLast;
    }

    public String getUserIdLastChange() {
        return userIdLastChange;
    }

    public void setUserIdLastChange(String userIdLastChange) {
        this.userIdLastChange = userIdLastChange;
    }

    public boolean isSimulation() {
        return simulation;
    }

    public void setSimulation(boolean simulation) {
        this.simulation = simulation;
    }
}