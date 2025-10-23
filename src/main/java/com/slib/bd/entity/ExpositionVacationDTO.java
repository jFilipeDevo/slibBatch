package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExpositionVacationDTO {
    private Long id;
    private LocalDateTime timestamp;
    private Integer checkPriceAlert;
    private BigDecimal finalExposure;
    private Integer missingFxRate;
    private Integer missingPrice;
    private Integer outOfDateFxRate;
    private Integer outOfDatePrice;
    private BigDecimal riskMeasure;
    private String status;
    private Integer version;
    private Long riskUnitId;
    private Long formerExpositionVacationId;
    private BigDecimal finalExposureCl;
    private BigDecimal creditLineRate;
    private BigDecimal globalAddOn;
    private Integer defaultPrice;
    private BigDecimal cashAmount;
    private BigDecimal riskAmount;
    private LocalDateTime endDate;
    private LocalDateTime flux3ReceiveDate;
    private Integer criticalAlertLevel;
    private BigDecimal creditLine;
    private String creditLineCurrencyRefId;
    private LocalDateTime bktBeginDate;
    private LocalDateTime bktEndDate;
    private boolean bktReady;
    private String bktRuCurrencyRefId;
    private LocalDate bktSelectionDate;
    private String bktSelectionCriteria;
    private LocalTime bktRuStartTime;
    private LocalTime bktRuEndTime;
    private String bktRuTimezone;
    private Boolean bktSent;
    private BigDecimal collateralUsed;
    private String context;
    private BigDecimal fixedCollateral;
    private LocalDateTime collateralOldestDate;
    private BigDecimal marginCashBalance;
    private LocalDateTime marginCashBalanceDate;
    private String ruMarginingStatus;
    private String ptfMarginingWorstStatus;
    private String formulaEquation;
    private String marginCashBalanceCurrency;
    private String fixedCollateralCurrency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCheckPriceAlert() {
        return checkPriceAlert;
    }

    public void setCheckPriceAlert(Integer checkPriceAlert) {
        this.checkPriceAlert = checkPriceAlert;
    }

    public BigDecimal getFinalExposure() {
        return finalExposure;
    }

    public void setFinalExposure(BigDecimal finalExposure) {
        this.finalExposure = finalExposure;
    }

    public Integer getMissingFxRate() {
        return missingFxRate;
    }

    public void setMissingFxRate(Integer missingFxRate) {
        this.missingFxRate = missingFxRate;
    }

    public Integer getMissingPrice() {
        return missingPrice;
    }

    public void setMissingPrice(Integer missingPrice) {
        this.missingPrice = missingPrice;
    }

    public Integer getOutOfDateFxRate() {
        return outOfDateFxRate;
    }

    public void setOutOfDateFxRate(Integer outOfDateFxRate) {
        this.outOfDateFxRate = outOfDateFxRate;
    }

    public Integer getOutOfDatePrice() {
        return outOfDatePrice;
    }

    public void setOutOfDatePrice(Integer outOfDatePrice) {
        this.outOfDatePrice = outOfDatePrice;
    }

    public BigDecimal getRiskMeasure() {
        return riskMeasure;
    }

    public void setRiskMeasure(BigDecimal riskMeasure) {
        this.riskMeasure = riskMeasure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getRiskUnitId() {
        return riskUnitId;
    }

    public void setRiskUnitId(Long riskUnitId) {
        this.riskUnitId = riskUnitId;
    }

    public Long getFormerExpositionVacationId() {
        return formerExpositionVacationId;
    }

    public void setFormerExpositionVacationId(Long formerExpositionVacationId) {
        this.formerExpositionVacationId = formerExpositionVacationId;
    }

    public BigDecimal getFinalExposureCl() {
        return finalExposureCl;
    }

    public void setFinalExposureCl(BigDecimal finalExposureCl) {
        this.finalExposureCl = finalExposureCl;
    }

    public BigDecimal getCreditLineRate() {
        return creditLineRate;
    }

    public void setCreditLineRate(BigDecimal creditLineRate) {
        this.creditLineRate = creditLineRate;
    }

    public BigDecimal getGlobalAddOn() {
        return globalAddOn;
    }

    public void setGlobalAddOn(BigDecimal globalAddOn) {
        this.globalAddOn = globalAddOn;
    }

    public Integer getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Integer defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getRiskAmount() {
        return riskAmount;
    }

    public void setRiskAmount(BigDecimal riskAmount) {
        this.riskAmount = riskAmount;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getFlux3ReceiveDate() {
        return flux3ReceiveDate;
    }

    public void setFlux3ReceiveDate(LocalDateTime flux3ReceiveDate) {
        this.flux3ReceiveDate = flux3ReceiveDate;
    }

    public Integer getCriticalAlertLevel() {
        return criticalAlertLevel;
    }

    public void setCriticalAlertLevel(Integer criticalAlertLevel) {
        this.criticalAlertLevel = criticalAlertLevel;
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }

    public String getCreditLineCurrencyRefId() {
        return creditLineCurrencyRefId;
    }

    public void setCreditLineCurrencyRefId(String creditLineCurrencyRefId) {
        this.creditLineCurrencyRefId = creditLineCurrencyRefId;
    }

    public LocalDateTime getBktBeginDate() {
        return bktBeginDate;
    }

    public void setBktBeginDate(LocalDateTime bktBeginDate) {
        this.bktBeginDate = bktBeginDate;
    }

    public LocalDateTime getBktEndDate() {
        return bktEndDate;
    }

    public void setBktEndDate(LocalDateTime bktEndDate) {
        this.bktEndDate = bktEndDate;
    }

    public boolean isBktReady() {
        return bktReady;
    }

    public void setBktReady(boolean bktReady) {
        this.bktReady = bktReady;
    }

    public String getBktRuCurrencyRefId() {
        return bktRuCurrencyRefId;
    }

    public void setBktRuCurrencyRefId(String bktRuCurrencyRefId) {
        this.bktRuCurrencyRefId = bktRuCurrencyRefId;
    }

    public LocalDate getBktSelectionDate() {
        return bktSelectionDate;
    }

    public void setBktSelectionDate(LocalDate bktSelectionDate) {
        this.bktSelectionDate = bktSelectionDate;
    }

    public String getBktSelectionCriteria() {
        return bktSelectionCriteria;
    }

    public void setBktSelectionCriteria(String bktSelectionCriteria) {
        this.bktSelectionCriteria = bktSelectionCriteria;
    }

    public LocalTime getBktRuStartTime() {
        return bktRuStartTime;
    }

    public void setBktRuStartTime(LocalTime bktRuStartTime) {
        this.bktRuStartTime = bktRuStartTime;
    }

    public LocalTime getBktRuEndTime() {
        return bktRuEndTime;
    }

    public void setBktRuEndTime(LocalTime bktRuEndTime) {
        this.bktRuEndTime = bktRuEndTime;
    }

    public String getBktRuTimezone() {
        return bktRuTimezone;
    }

    public void setBktRuTimezone(String bktRuTimezone) {
        this.bktRuTimezone = bktRuTimezone;
    }

    public Boolean getBktSent() {
        return bktSent;
    }

    public void setBktSent(Boolean bktSent) {
        this.bktSent = bktSent;
    }

    public BigDecimal getCollateralUsed() {
        return collateralUsed;
    }

    public void setCollateralUsed(BigDecimal collateralUsed) {
        this.collateralUsed = collateralUsed;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigDecimal getFixedCollateral() {
        return fixedCollateral;
    }

    public void setFixedCollateral(BigDecimal fixedCollateral) {
        this.fixedCollateral = fixedCollateral;
    }

    public LocalDateTime getCollateralOldestDate() {
        return collateralOldestDate;
    }

    public void setCollateralOldestDate(LocalDateTime collateralOldestDate) {
        this.collateralOldestDate = collateralOldestDate;
    }

    public BigDecimal getMarginCashBalance() {
        return marginCashBalance;
    }

    public void setMarginCashBalance(BigDecimal marginCashBalance) {
        this.marginCashBalance = marginCashBalance;
    }

    public LocalDateTime getMarginCashBalanceDate() {
        return marginCashBalanceDate;
    }

    public void setMarginCashBalanceDate(LocalDateTime marginCashBalanceDate) {
        this.marginCashBalanceDate = marginCashBalanceDate;
    }

    public String getRuMarginingStatus() {
        return ruMarginingStatus;
    }

    public void setRuMarginingStatus(String ruMarginingStatus) {
        this.ruMarginingStatus = ruMarginingStatus;
    }

    public String getPtfMarginingWorstStatus() {
        return ptfMarginingWorstStatus;
    }

    public void setPtfMarginingWorstStatus(String ptfMarginingWorstStatus) {
        this.ptfMarginingWorstStatus = ptfMarginingWorstStatus;
    }

    public String getFormulaEquation() {
        return formulaEquation;
    }

    public void setFormulaEquation(String formulaEquation) {
        this.formulaEquation = formulaEquation;
    }

    public String getMarginCashBalanceCurrency() {
        return marginCashBalanceCurrency;
    }

    public void setMarginCashBalanceCurrency(String marginCashBalanceCurrency) {
        this.marginCashBalanceCurrency = marginCashBalanceCurrency;
    }

    public String getFixedCollateralCurrency() {
        return fixedCollateralCurrency;
    }

    public void setFixedCollateralCurrency(String fixedCollateralCurrency) {
        this.fixedCollateralCurrency = fixedCollateralCurrency;
    }
}