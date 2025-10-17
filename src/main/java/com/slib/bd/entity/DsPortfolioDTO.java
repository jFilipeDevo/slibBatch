package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for the ds_portfolio table.
 * Used by JdbcCursorItemReader with BeanPropertyRowMapper.
 * Field names MUST match the SQL column aliases exactly.
 */
public class DsPortfolioDTO {
    private BigDecimal dsId;
    private BigDecimal id;
    private BigDecimal expositionVacationId;

    private BigDecimal computedVar;
    private LocalDateTime constitutionDate;
    private String name;
    private String type;
    private BigDecimal value;
    private Boolean valueOk;
    private LocalDateTime sendingDate;
    private String status;
    private LocalDateTime varDate;
    private Long version;
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
    private Boolean portfolioExcluded;
    private LocalDate insertDate;
    private LocalDateTime insertDateTime;
    private String lcn;
    private BigDecimal dfMultiplier;

    public DsPortfolioDTO() {}

    public BigDecimal getDsId() { return dsId; }
    public void setDsId(BigDecimal dsId) { this.dsId = dsId; }

    public BigDecimal getId() { return id; }
    public void setId(BigDecimal id) { this.id = id; }

    public BigDecimal getExpositionVacationId() { return expositionVacationId; }
    public void setExpositionVacationId(BigDecimal expositionVacationId) { this.expositionVacationId = expositionVacationId; }

    public BigDecimal getComputedVar() { return computedVar; }
    public void setComputedVar(BigDecimal computedVar) { this.computedVar = computedVar; }

    public LocalDateTime getConstitutionDate() { return constitutionDate; }
    public void setConstitutionDate(LocalDateTime constitutionDate) { this.constitutionDate = constitutionDate; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getSendingDate() { return sendingDate; }
    public void setSendingDate(LocalDateTime sendingDate) { this.sendingDate = sendingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }

    public Boolean getValueOk() { return valueOk; }
    public void setValueOk(Boolean valueOk) { this.valueOk = valueOk; }

    public LocalDateTime getVarDate() { return varDate; }
    public void setVarDate(LocalDateTime varDate) { this.varDate = varDate; }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

    public BigDecimal getGlobalAddOn() { return globalAddOn; }
    public void setGlobalAddOn(BigDecimal globalAddOn) { this.globalAddOn = globalAddOn; }

    public BigDecimal getRawGlobalAddOn() { return rawGlobalAddOn; }
    public void setRawGlobalAddOn(BigDecimal rawGlobalAddOn) { this.rawGlobalAddOn = rawGlobalAddOn; }

    public BigDecimal getTotalAddOn() { return totalAddOn; }
    public void setTotalAddOn(BigDecimal totalAddOn) { this.totalAddOn = totalAddOn; }

    public BigDecimal getHoldingAddOn() { return holdingAddOn; }
    public void setHoldingAddOn(BigDecimal holdingAddOn) { this.holdingAddOn = holdingAddOn; }

    public BigDecimal getTotalMarketValue() { return totalMarketValue; }
    public void setTotalMarketValue(BigDecimal totalMarketValue) { this.totalMarketValue = totalMarketValue; }

    public BigDecimal getHoldingMarketValue() { return holdingMarketValue; }
    public void setHoldingMarketValue(BigDecimal holdingMarketValue) { this.holdingMarketValue = holdingMarketValue; }

    public String getTotalStatus() { return totalStatus; }
    public void setTotalStatus(String totalStatus) { this.totalStatus = totalStatus; }

    public String getHoldingStatus() { return holdingStatus; }
    public void setHoldingStatus(String holdingStatus) { this.holdingStatus = holdingStatus; }

    public BigDecimal getGlobalFallbackRatio() { return globalFallbackRatio; }
    public void setGlobalFallbackRatio(BigDecimal globalFallbackRatio) { this.globalFallbackRatio = globalFallbackRatio; }

    public BigDecimal getTotalFallbackRatio() { return totalFallbackRatio; }
    public void setTotalFallbackRatio(BigDecimal totalFallbackRatio) { this.totalFallbackRatio = totalFallbackRatio; }

    public BigDecimal getHoldingFallbackRatio() { return holdingFallbackRatio; }
    public void setHoldingFallbackRatio(BigDecimal holdingFallbackRatio) { this.holdingFallbackRatio = holdingFallbackRatio; }

    public BigDecimal getGlobalAdvRatio() { return globalAdvRatio; }
    public void setGlobalAdvRatio(BigDecimal globalAdvRatio) { this.globalAdvRatio = globalAdvRatio; }

    public BigDecimal getTotalAdvRatio() { return totalAdvRatio; }
    public void setTotalAdvRatio(BigDecimal totalAdvRatio) { this.totalAdvRatio = totalAdvRatio; }

    public BigDecimal getHoldingAdvRatio() { return holdingAdvRatio; }
    public void setHoldingAdvRatio(BigDecimal holdingAdvRatio) { this.holdingAdvRatio = holdingAdvRatio; }

    public BigDecimal getGlobalMvRatio() { return globalMvRatio; }
    public void setGlobalMvRatio(BigDecimal globalMvRatio) { this.globalMvRatio = globalMvRatio; }

    public BigDecimal getTotalMvRatio() { return totalMvRatio; }
    public void setTotalMvRatio(BigDecimal totalMvRatio) { this.totalMvRatio = totalMvRatio; }

    public BigDecimal getHoldingMvRatio() { return holdingMvRatio; }
    public void setHoldingMvRatio(BigDecimal holdingMvRatio) { this.holdingMvRatio = holdingMvRatio; }

    public BigDecimal getGlobalRtgRatio() { return globalRtgRatio; }
    public void setGlobalRtgRatio(BigDecimal globalRtgRatio) { this.globalRtgRatio = globalRtgRatio; }

    public BigDecimal getTotalRtgRatio() { return totalRtgRatio; }
    public void setTotalRtgRatio(BigDecimal totalRtgRatio) { this.totalRtgRatio = totalRtgRatio; }

    public BigDecimal getHoldingRtgRatio() { return holdingRtgRatio; }
    public void setHoldingRtgRatio(BigDecimal holdingRtgRatio) { this.holdingRtgRatio = holdingRtgRatio; }

    public BigDecimal getMarginingMr() { return marginingMr; }
    public void setMarginingMr(BigDecimal marginingMr) { this.marginingMr = marginingMr; }

    public BigDecimal getMarginingIm() { return marginingIm; }
    public void setMarginingIm(BigDecimal marginingIm) { this.marginingIm = marginingIm; }

    public BigDecimal getMarginingVm() { return marginingVm; }
    public void setMarginingVm(BigDecimal marginingVm) { this.marginingVm = marginingVm; }

    public BigDecimal getMarginingLcrm() { return marginingLcrm; }
    public void setMarginingLcrm(BigDecimal marginingLcrm) { this.marginingLcrm = marginingLcrm; }

    public BigDecimal getMarginingWwr() { return marginingWwr; }
    public void setMarginingWwr(BigDecimal marginingWwr) { this.marginingWwr = marginingWwr; }

    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }

    public String getComputationCurrencyRefId() { return computationCurrencyRefId; }
    public void setComputationCurrencyRefId(String computationCurrencyRefId) { this.computationCurrencyRefId = computationCurrencyRefId; }

    public String getRuCurrencyRefId() { return ruCurrencyRefId; }
    public void setRuCurrencyRefId(String ruCurrencyRefId) { this.ruCurrencyRefId = ruCurrencyRefId; }

    public BigDecimal getConversionRate() { return conversionRate; }
    public void setConversionRate(BigDecimal conversionRate) { this.conversionRate = conversionRate; }

    public LocalDate getExchangeRateDate() { return exchangeRateDate; }
    public void setExchangeRateDate(LocalDate exchangeRateDate) { this.exchangeRateDate = exchangeRateDate; }

    public BigDecimal getMarginingMrOriginal() { return marginingMrOriginal; }
    public void setMarginingMrOriginal(BigDecimal marginingMrOriginal) { this.marginingMrOriginal = marginingMrOriginal; }

    public String getMarginingStatus() { return marginingStatus; }
    public void setMarginingStatus(String marginingStatus) { this.marginingStatus = marginingStatus; }

    public String getContext() { return context; }
    public void setContext(String context) { this.context = context; }

    public BigDecimal getFallbackPortfolioId() { return fallbackPortfolioId; }
    public void setFallbackPortfolioId(BigDecimal fallbackPortfolioId) { this.fallbackPortfolioId = fallbackPortfolioId; }

    public Boolean getPortfolioExcluded() { return portfolioExcluded; }
    public void setPortfolioExcluded(Boolean portfolioExcluded) { this.portfolioExcluded = portfolioExcluded; }

    public LocalDate getInsertDate() { return insertDate; }
    public void setInsertDate(LocalDate insertDate) { this.insertDate = insertDate; }

    public LocalDateTime getInsertDateTime() { return insertDateTime; }
    public void setInsertDateTime(LocalDateTime insertDateTime) { this.insertDateTime = insertDateTime; }

    public String getLcn() { return lcn; }
    public void setLcn(String lcn) { this.lcn = lcn; }

    public BigDecimal getDfMultiplier() { return dfMultiplier; }
    public void setDfMultiplier(BigDecimal dfMultiplier) { this.dfMultiplier = dfMultiplier; }

    public String getLogFileId() { return null; } // Log fields typically not mapped for read/write
    public void setLogFileId(String logFileId) { }

    public BigDecimal getBktMarketValue() { return null; }
    public void setBktMarketValue(BigDecimal bktMarketValue) { }

    public BigDecimal getBktMarkToMarket() { return null; }
    public void setBktMarkToMarket(BigDecimal bktMarkToMarket) { }
}