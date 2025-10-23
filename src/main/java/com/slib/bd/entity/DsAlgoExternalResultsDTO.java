package com.slib.bd.entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DsAlgoExternalResultsDTO {
    private Long dsId;
    private Long id;
    private String ptfKey;
    private String ccpAccountId;
    private String ccpId;
    private String tpId;
    private String bucketId;
    private String memberId;
    private String algorithm;
    private LocalDateTime computationDatetime;
    private String currency;
    private BigDecimal mr;
    private BigDecimal im;
    private BigDecimal vm;
    private BigDecimal am;
    private BigDecimal lcrm;
    private BigDecimal wwrm;
    private BigDecimal cf;
    private LocalDateTime extractionId;
    private String status;
    private String context;
    private String createdByUser;
    private String approvedByUser;
    private LocalDateTime createdAt;
    private BigDecimal accountId;
    private String operation;
    private LocalDate insertDate;

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

    public String getPtfKey() {
        return ptfKey;
    }

    public void setPtfKey(String ptfKey) {
        this.ptfKey = ptfKey;
    }

    public String getCcpAccountId() {
        return ccpAccountId;
    }

    public void setCcpAccountId(String ccpAccountId) {
        this.ccpAccountId = ccpAccountId;
    }

    public String getCcpId() {
        return ccpId;
    }

    public void setCcpId(String ccpId) {
        this.ccpId = ccpId;
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    public String getBucketId() {
        return bucketId;
    }

    public void setBucketId(String bucketId) {
        this.bucketId = bucketId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public LocalDateTime getComputationDatetime() {
        return computationDatetime;
    }

    public void setComputationDatetime(LocalDateTime computationDatetime) {
        this.computationDatetime = computationDatetime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getMr() {
        return mr;
    }

    public void setMr(BigDecimal mr) {
        this.mr = mr;
    }

    public BigDecimal getIm() {
        return im;
    }

    public void setIm(BigDecimal im) {
        this.im = im;
    }

    public BigDecimal getVm() {
        return vm;
    }

    public void setVm(BigDecimal vm) {
        this.vm = vm;
    }

    public BigDecimal getAm() {
        return am;
    }

    public void setAm(BigDecimal am) {
        this.am = am;
    }

    public BigDecimal getLcrm() {
        return lcrm;
    }

    public void setLcrm(BigDecimal lcrm) {
        this.lcrm = lcrm;
    }

    public BigDecimal getWwrm() {
        return wwrm;
    }

    public void setWwrm(BigDecimal wwrm) {
        this.wwrm = wwrm;
    }

    public BigDecimal getCf() {
        return cf;
    }

    public void setCf(BigDecimal cf) {
        this.cf = cf;
    }

    public LocalDateTime getExtractionId() {
        return extractionId;
    }

    public void setExtractionId(LocalDateTime extractionId) {
        this.extractionId = extractionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getApprovedByUser() {
        return approvedByUser;
    }

    public void setApprovedByUser(String approvedByUser) {
        this.approvedByUser = approvedByUser;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getAccountId() {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }
}