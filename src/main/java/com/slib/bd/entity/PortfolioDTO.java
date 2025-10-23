package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PortfolioDTO {
    private Long id;
    private Long expositionVacationId;
    private BigDecimal computedVar;
    private LocalDateTime constitutionDate;
    private String name;
    private LocalDateTime sendingDate;
    private String status;
    private String type;
    private BigDecimal value;
    private Boolean valueOk;
    private LocalDateTime varDate;
    private Integer version;
    private BigDecimal globalAddOn;
    private BigDecimal rawGlobalAddOn;
    private BigDecimal totalAddOn;
    private BigDecimal holdingAddOn;
    private BigDecimal totalMarketValue;
    private BigDecimal holdingMarketValue;
    private String totalStatus;
    private String holdingStatus;
    private BigDecimal globalFallbackRatio;
    private BigDecimal totalFallbackRatio;
    private BigDecimal holdingFallbackRatio;
    private BigDecimal globalAdvRatio;
    private BigDecimal totalAdvRatio;
    private BigDecimal holdingAdvRatio;
    private BigDecimal globalMvRatio;
    private BigDecimal totalMvRatio;
    private BigDecimal holdingMvRatio;
    private BigDecimal globalRtgRatio;
    private BigDecimal totalRtgRatio;
    private BigDecimal holdingRtgRatio;
    private String logFileId;
    private BigDecimal bktMarketValue;
    private BigDecimal bktMarkToMarket;
    private BigDecimal marginingMr;
    private BigDecimal marginingIm;
    private BigDecimal marginingVm;
    private BigDecimal marginingLcrm;
    private BigDecimal marginingWwr;
    private String algorithm;
    private String computationCurrencyRefId;
    private String ruCurrencyRefId;
    private BigDecimal conversionRate;
    private LocalDate exchangeRateDate;
    private BigDecimal marginingMrOriginal;
    private String marginingStatus;
    private String context;
    private BigDecimal fallbackPortfolioId;
    private boolean portfolioExcluded;
    private BigDecimal marginingCf;
    private String lcn;
    private BigDecimal requirementToApprove;
    private Boolean marginingMrModifiedByUser;
    private BigDecimal marginingMrAlgorithm;
    private BigDecimal lastCoefficientUsed;
    private BigDecimal dfMultiplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExpositionVacationId() {
        return expositionVacationId;
    }

    public void setExpositionVacationId(Long expositionVacationId) {
        this.expositionVacationId = expositionVacationId;
    }

    public BigDecimal getComputedVar() {
        return computedVar;
    }

    public void setComputedVar(BigDecimal computedVar) {
        this.computedVar = computedVar;
    }

    public LocalDateTime getConstitutionDate() {
        return constitutionDate;
    }

    public void setConstitutionDate(LocalDateTime constitutionDate) {
        this.constitutionDate = constitutionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(LocalDateTime sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getValueOk() {
        return valueOk;
    }

    public void setValueOk(Boolean valueOk) {
        this.valueOk = valueOk;
    }

    public LocalDateTime getVarDate() {
        return varDate;
    }

    public void setVarDate(LocalDateTime varDate) {
        this.varDate = varDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getGlobalAddOn() {
        return globalAddOn;
    }

    public void setGlobalAddOn(BigDecimal globalAddOn) {
        this.globalAddOn = globalAddOn;
    }

    public BigDecimal getRawGlobalAddOn() {
        return rawGlobalAddOn;
    }

    public void setRawGlobalAddOn(BigDecimal rawGlobalAddOn) {
        this.rawGlobalAddOn = rawGlobalAddOn;
    }

    public BigDecimal getTotalAddOn() {
        return totalAddOn;
    }

    public void setTotalAddOn(BigDecimal totalAddOn) {
        this.totalAddOn = totalAddOn;
    }

    public BigDecimal getHoldingAddOn() {
        return holdingAddOn;
    }

    public void setHoldingAddOn(BigDecimal holdingAddOn) {
        this.holdingAddOn = holdingAddOn;
    }

    public BigDecimal getTotalMarketValue() {
        return totalMarketValue;
    }

    public void setTotalMarketValue(BigDecimal totalMarketValue) {
        this.totalMarketValue = totalMarketValue;
    }

    public BigDecimal getHoldingMarketValue() {
        return holdingMarketValue;
    }

    public void setHoldingMarketValue(BigDecimal holdingMarketValue) {
        this.holdingMarketValue = holdingMarketValue;
    }

    public String getTotalStatus() {
        return totalStatus;
    }

    public void setTotalStatus(String totalStatus) {
        this.totalStatus = totalStatus;
    }

    public String getHoldingStatus() {
        return holdingStatus;
    }

    public void setHoldingStatus(String holdingStatus) {
        this.holdingStatus = holdingStatus;
    }

    public BigDecimal getGlobalFallbackRatio() {
        return globalFallbackRatio;
    }

    public void setGlobalFallbackRatio(BigDecimal globalFallbackRatio) {
        this.globalFallbackRatio = globalFallbackRatio;
    }

    public BigDecimal getTotalFallbackRatio() {
        return totalFallbackRatio;
    }

    public void setTotalFallbackRatio(BigDecimal totalFallbackRatio) {
        this.totalFallbackRatio = totalFallbackRatio;
    }

    public BigDecimal getHoldingFallbackRatio() {
        return holdingFallbackRatio;
    }

    public void setHoldingFallbackRatio(BigDecimal holdingFallbackRatio) {
        this.holdingFallbackRatio = holdingFallbackRatio;
    }

    public BigDecimal getGlobalAdvRatio() {
        return globalAdvRatio;
    }

    public void setGlobalAdvRatio(BigDecimal globalAdvRatio) {
        this.globalAdvRatio = globalAdvRatio;
    }

    public BigDecimal getTotalAdvRatio() {
        return totalAdvRatio;
    }

    public void setTotalAdvRatio(BigDecimal totalAdvRatio) {
        this.totalAdvRatio = totalAdvRatio;
    }

    public BigDecimal getHoldingAdvRatio() {
        return holdingAdvRatio;
    }

    public void setHoldingAdvRatio(BigDecimal holdingAdvRatio) {
        this.holdingAdvRatio = holdingAdvRatio;
    }

    public BigDecimal getGlobalMvRatio() {
        return globalMvRatio;
    }

    public void setGlobalMvRatio(BigDecimal globalMvRatio) {
        this.globalMvRatio = globalMvRatio;
    }

    public BigDecimal getTotalMvRatio() {
        return totalMvRatio;
    }

    public void setTotalMvRatio(BigDecimal totalMvRatio) {
        this.totalMvRatio = totalMvRatio;
    }

    public BigDecimal getHoldingMvRatio() {
        return holdingMvRatio;
    }

    public void setHoldingMvRatio(BigDecimal holdingMvRatio) {
        this.holdingMvRatio = holdingMvRatio;
    }

    public BigDecimal getGlobalRtgRatio() {
        return globalRtgRatio;
    }

    public void setGlobalRtgRatio(BigDecimal globalRtgRatio) {
        this.globalRtgRatio = globalRtgRatio;
    }

    public BigDecimal getTotalRtgRatio() {
        return totalRtgRatio;
    }

    public void setTotalRtgRatio(BigDecimal totalRtgRatio) {
        this.totalRtgRatio = totalRtgRatio;
    }

    public BigDecimal getHoldingRtgRatio() {
        return holdingRtgRatio;
    }

    public void setHoldingRtgRatio(BigDecimal holdingRtgRatio) {
        this.holdingRtgRatio = holdingRtgRatio;
    }

    public String getLogFileId() {
        return logFileId;
    }

    public void setLogFileId(String logFileId) {
        this.logFileId = logFileId;
    }

    public BigDecimal getBktMarketValue() {
        return bktMarketValue;
    }

    public void setBktMarketValue(BigDecimal bktMarketValue) {
        this.bktMarketValue = bktMarketValue;
    }

    public BigDecimal getBktMarkToMarket() {
        return bktMarkToMarket;
    }

    public void setBktMarkToMarket(BigDecimal bktMarkToMarket) {
        this.bktMarkToMarket = bktMarkToMarket;
    }

    public BigDecimal getMarginingMr() {
        return marginingMr;
    }

    public void setMarginingMr(BigDecimal marginingMr) {
        this.marginingMr = marginingMr;
    }

    public BigDecimal getMarginingIm() {
        return marginingIm;
    }

    public void setMarginingIm(BigDecimal marginingIm) {
        this.marginingIm = marginingIm;
    }

    public BigDecimal getMarginingVm() {
        return marginingVm;
    }

    public void setMarginingVm(BigDecimal marginingVm) {
        this.marginingVm = marginingVm;
    }

    public BigDecimal getMarginingLcrm() {
        return marginingLcrm;
    }

    public void setMarginingLcrm(BigDecimal marginingLcrm) {
        this.marginingLcrm = marginingLcrm;
    }

    public BigDecimal getMarginingWwr() {
        return marginingWwr;
    }

    public void setMarginingWwr(BigDecimal marginingWwr) {
        this.marginingWwr = marginingWwr;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getComputationCurrencyRefId() {
        return computationCurrencyRefId;
    }

    public void setComputationCurrencyRefId(String computationCurrencyRefId) {
        this.computationCurrencyRefId = computationCurrencyRefId;
    }

    public String getRuCurrencyRefId() {
        return ruCurrencyRefId;
    }

    public void setRuCurrencyRefId(String ruCurrencyRefId) {
        this.ruCurrencyRefId = ruCurrencyRefId;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public LocalDate getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(LocalDate exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public BigDecimal getMarginingMrOriginal() {
        return marginingMrOriginal;
    }

    public void setMarginingMrOriginal(BigDecimal marginingMrOriginal) {
        this.marginingMrOriginal = marginingMrOriginal;
    }

    public String getMarginingStatus() {
        return marginingStatus;
    }

    public void setMarginingStatus(String marginingStatus) {
        this.marginingStatus = marginingStatus;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigDecimal getFallbackPortfolioId() {
        return fallbackPortfolioId;
    }

    public void setFallbackPortfolioId(BigDecimal fallbackPortfolioId) {
        this.fallbackPortfolioId = fallbackPortfolioId;
    }

    public boolean isPortfolioExcluded() {
        return portfolioExcluded;
    }

    public void setPortfolioExcluded(boolean portfolioExcluded) {
        this.portfolioExcluded = portfolioExcluded;
    }

    public BigDecimal getMarginingCf() {
        return marginingCf;
    }

    public void setMarginingCf(BigDecimal marginingCf) {
        this.marginingCf = marginingCf;
    }

    public String getLcn() {
        return lcn;
    }

    public void setLcn(String lcn) {
        this.lcn = lcn;
    }

    public BigDecimal getRequirementToApprove() {
        return requirementToApprove;
    }

    public void setRequirementToApprove(BigDecimal requirementToApprove) {
        this.requirementToApprove = requirementToApprove;
    }

    public Boolean getMarginingMrModifiedByUser() {
        return marginingMrModifiedByUser;
    }

    public void setMarginingMrModifiedByUser(Boolean marginingMrModifiedByUser) {
        this.marginingMrModifiedByUser = marginingMrModifiedByUser;
    }

    public BigDecimal getMarginingMrAlgorithm() {
        return marginingMrAlgorithm;
    }

    public void setMarginingMrAlgorithm(BigDecimal marginingMrAlgorithm) {
        this.marginingMrAlgorithm = marginingMrAlgorithm;
    }

    public BigDecimal getLastCoefficientUsed() {
        return lastCoefficientUsed;
    }

    public void setLastCoefficientUsed(BigDecimal lastCoefficientUsed) {
        this.lastCoefficientUsed = lastCoefficientUsed;
    }

    public BigDecimal getDfMultiplier() {
        return dfMultiplier;
    }

    public void setDfMultiplier(BigDecimal dfMultiplier) {
        this.dfMultiplier = dfMultiplier;
    }
}