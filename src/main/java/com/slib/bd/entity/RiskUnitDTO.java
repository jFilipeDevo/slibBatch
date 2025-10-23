package com.slib.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RiskUnitDTO {
    private Long id;
    private String accessCode;
    private BigDecimal creditLine;
    private Boolean financing;
    private String identification;
    private LocalDateTime lastVarComputationDate;
    private String name;
    private Long idOrigin;
    private String setup;
    private Integer varComputationPeriod;
    private Integer version;
    private Long clientEntityId;
    private String mrCurrencyRefId;
    private String referenceCurrencyRefId;
    private Long lastExpositionVacationId;
    private Long varParametersId;
    private String branch;
    private String crdsId;
    private String creditLineCurrencyRefId;
    private LocalDateTime creditLineLastUpdate;
    private BigDecimal lowestFinalExposureCl;
    private Long lowestFeVacationId;
    private Boolean btf;
    private BigDecimal fundingCreditLine;
    private LocalDateTime fundingClLastUpdate;
    private BigDecimal btfHaircut;
    private boolean btfCashRequestMatching;
    private String description;
    private Long alertGroupId;
    private Integer otcMinSettlementDate;
    private Integer otcMaxSettlementDate;
    private String computationModeCode;
    private LocalTime computationMinBound;
    private LocalTime computationMaxBound;
    private LocalDateTime flux2SendDate;
    private Long btfThreshold;
    private Integer criticalAlertLevel;
    private Integer alertLevel;
    private String uniqueId;
    private LocalTime bktStartTime;
    private LocalTime bktEndTime;
    private String bktTimezone;
    private LocalDate bktLastSelection;
    private boolean gcm;
    private boolean simulation;
    private BigDecimal ptfSimExecId;
    private boolean marginingEnabled;
    private Long marginingConfigId;
    private String marginingFormulaType;
    private BigDecimal minimumDeposit;
    private Boolean dualMode;
    private String bicCode;
    private Long gcmExternalRelatedRiskUnitId;
    private Boolean adjustedAlgorithm;
    private Boolean stressTest;
    private BigDecimal stBaseShock;
    private BigDecimal stLiquidityAddOnShock;
    private BigDecimal stCurrencyShock;
    private LocalDate stActivationDate;
    private LocalDate stDeactivationDate;
    private Boolean spikeEodTrigger;
    private BigDecimal spikeTriggerValue;
    private Boolean riskAlertTrigger;
    private Integer alertTriggerLevel;
    private Boolean timeslotTrigger;
    private String spikeTriggerType;

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

    public Boolean getFinancing() {
        return financing;
    }

    public void setFinancing(Boolean financing) {
        this.financing = financing;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public LocalDateTime getLastVarComputationDate() {
        return lastVarComputationDate;
    }

    public void setLastVarComputationDate(LocalDateTime lastVarComputationDate) {
        this.lastVarComputationDate = lastVarComputationDate;
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

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public Integer getVarComputationPeriod() {
        return varComputationPeriod;
    }

    public void setVarComputationPeriod(Integer varComputationPeriod) {
        this.varComputationPeriod = varComputationPeriod;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getClientEntityId() {
        return clientEntityId;
    }

    public void setClientEntityId(Long clientEntityId) {
        this.clientEntityId = clientEntityId;
    }

    public String getMrCurrencyRefId() {
        return mrCurrencyRefId;
    }

    public void setMrCurrencyRefId(String mrCurrencyRefId) {
        this.mrCurrencyRefId = mrCurrencyRefId;
    }

    public String getReferenceCurrencyRefId() {
        return referenceCurrencyRefId;
    }

    public void setReferenceCurrencyRefId(String referenceCurrencyRefId) {
        this.referenceCurrencyRefId = referenceCurrencyRefId;
    }

    public Long getLastExpositionVacationId() {
        return lastExpositionVacationId;
    }

    public void setLastExpositionVacationId(Long lastExpositionVacationId) {
        this.lastExpositionVacationId = lastExpositionVacationId;
    }

    public Long getVarParametersId() {
        return varParametersId;
    }

    public void setVarParametersId(Long varParametersId) {
        this.varParametersId = varParametersId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCrdsId() {
        return crdsId;
    }

    public void setCrdsId(String crdsId) {
        this.crdsId = crdsId;
    }

    public String getCreditLineCurrencyRefId() {
        return creditLineCurrencyRefId;
    }

    public void setCreditLineCurrencyRefId(String creditLineCurrencyRefId) {
        this.creditLineCurrencyRefId = creditLineCurrencyRefId;
    }

    public LocalDateTime getCreditLineLastUpdate() {
        return creditLineLastUpdate;
    }

    public void setCreditLineLastUpdate(LocalDateTime creditLineLastUpdate) {
        this.creditLineLastUpdate = creditLineLastUpdate;
    }

    public BigDecimal getLowestFinalExposureCl() {
        return lowestFinalExposureCl;
    }

    public void setLowestFinalExposureCl(BigDecimal lowestFinalExposureCl) {
        this.lowestFinalExposureCl = lowestFinalExposureCl;
    }

    public Long getLowestFeVacationId() {
        return lowestFeVacationId;
    }

    public void setLowestFeVacationId(Long lowestFeVacationId) {
        this.lowestFeVacationId = lowestFeVacationId;
    }

    public Boolean getBtf() {
        return btf;
    }

    public void setBtf(Boolean btf) {
        this.btf = btf;
    }

    public BigDecimal getFundingCreditLine() {
        return fundingCreditLine;
    }

    public void setFundingCreditLine(BigDecimal fundingCreditLine) {
        this.fundingCreditLine = fundingCreditLine;
    }

    public LocalDateTime getFundingClLastUpdate() {
        return fundingClLastUpdate;
    }

    public void setFundingClLastUpdate(LocalDateTime fundingClLastUpdate) {
        this.fundingClLastUpdate = fundingClLastUpdate;
    }

    public BigDecimal getBtfHaircut() {
        return btfHaircut;
    }

    public void setBtfHaircut(BigDecimal btfHaircut) {
        this.btfHaircut = btfHaircut;
    }

    public boolean isBtfCashRequestMatching() {
        return btfCashRequestMatching;
    }

    public void setBtfCashRequestMatching(boolean btfCashRequestMatching) {
        this.btfCashRequestMatching = btfCashRequestMatching;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAlertGroupId() {
        return alertGroupId;
    }

    public void setAlertGroupId(Long alertGroupId) {
        this.alertGroupId = alertGroupId;
    }

    public Integer getOtcMinSettlementDate() {
        return otcMinSettlementDate;
    }

    public void setOtcMinSettlementDate(Integer otcMinSettlementDate) {
        this.otcMinSettlementDate = otcMinSettlementDate;
    }

    public Integer getOtcMaxSettlementDate() {
        return otcMaxSettlementDate;
    }

    public void setOtcMaxSettlementDate(Integer otcMaxSettlementDate) {
        this.otcMaxSettlementDate = otcMaxSettlementDate;
    }

    public String getComputationModeCode() {
        return computationModeCode;
    }

    public void setComputationModeCode(String computationModeCode) {
        this.computationModeCode = computationModeCode;
    }

    public LocalTime getComputationMinBound() {
        return computationMinBound;
    }

    public void setComputationMinBound(LocalTime computationMinBound) {
        this.computationMinBound = computationMinBound;
    }

    public LocalTime getComputationMaxBound() {
        return computationMaxBound;
    }

    public void setComputationMaxBound(LocalTime computationMaxBound) {
        this.computationMaxBound = computationMaxBound;
    }

    public LocalDateTime getFlux2SendDate() {
        return flux2SendDate;
    }

    public void setFlux2SendDate(LocalDateTime flux2SendDate) {
        this.flux2SendDate = flux2SendDate;
    }

    public Long getBtfThreshold() {
        return btfThreshold;
    }

    public void setBtfThreshold(Long btfThreshold) {
        this.btfThreshold = btfThreshold;
    }

    public Integer getCriticalAlertLevel() {
        return criticalAlertLevel;
    }

    public void setCriticalAlertLevel(Integer criticalAlertLevel) {
        this.criticalAlertLevel = criticalAlertLevel;
    }

    public Integer getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(Integer alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public LocalTime getBktStartTime() {
        return bktStartTime;
    }

    public void setBktStartTime(LocalTime bktStartTime) {
        this.bktStartTime = bktStartTime;
    }

    public LocalTime getBktEndTime() {
        return bktEndTime;
    }

    public void setBktEndTime(LocalTime bktEndTime) {
        this.bktEndTime = bktEndTime;
    }

    public String getBktTimezone() {
        return bktTimezone;
    }

    public void setBktTimezone(String bktTimezone) {
        this.bktTimezone = bktTimezone;
    }

    public LocalDate getBktLastSelection() {
        return bktLastSelection;
    }

    public void setBktLastSelection(LocalDate bktLastSelection) {
        this.bktLastSelection = bktLastSelection;
    }

    public boolean isGcm() {
        return gcm;
    }

    public void setGcm(boolean gcm) {
        this.gcm = gcm;
    }

    public boolean isSimulation() {
        return simulation;
    }

    public void setSimulation(boolean simulation) {
        this.simulation = simulation;
    }

    public BigDecimal getPtfSimExecId() {
        return ptfSimExecId;
    }

    public void setPtfSimExecId(BigDecimal ptfSimExecId) {
        this.ptfSimExecId = ptfSimExecId;
    }

    public boolean isMarginingEnabled() {
        return marginingEnabled;
    }

    public void setMarginingEnabled(boolean marginingEnabled) {
        this.marginingEnabled = marginingEnabled;
    }

    public Long getMarginingConfigId() {
        return marginingConfigId;
    }

    public void setMarginingConfigId(Long marginingConfigId) {
        this.marginingConfigId = marginingConfigId;
    }

    public String getMarginingFormulaType() {
        return marginingFormulaType;
    }

    public void setMarginingFormulaType(String marginingFormulaType) {
        this.marginingFormulaType = marginingFormulaType;
    }

    public BigDecimal getMinimumDeposit() {
        return minimumDeposit;
    }

    public void setMinimumDeposit(BigDecimal minimumDeposit) {
        this.minimumDeposit = minimumDeposit;
    }

    public Boolean getDualMode() {
        return dualMode;
    }

    public void setDualMode(Boolean dualMode) {
        this.dualMode = dualMode;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    public Long getGcmExternalRelatedRiskUnitId() {
        return gcmExternalRelatedRiskUnitId;
    }

    public void setGcmExternalRelatedRiskUnitId(Long gcmExternalRelatedRiskUnitId) {
        this.gcmExternalRelatedRiskUnitId = gcmExternalRelatedRiskUnitId;
    }

    public Boolean getAdjustedAlgorithm() {
        return adjustedAlgorithm;
    }

    public void setAdjustedAlgorithm(Boolean adjustedAlgorithm) {
        this.adjustedAlgorithm = adjustedAlgorithm;
    }

    public Boolean getStressTest() {
        return stressTest;
    }

    public void setStressTest(Boolean stressTest) {
        this.stressTest = stressTest;
    }

    public BigDecimal getStBaseShock() {
        return stBaseShock;
    }

    public void setStBaseShock(BigDecimal stBaseShock) {
        this.stBaseShock = stBaseShock;
    }

    public BigDecimal getStLiquidityAddOnShock() {
        return stLiquidityAddOnShock;
    }

    public void setStLiquidityAddOnShock(BigDecimal stLiquidityAddOnShock) {
        this.stLiquidityAddOnShock = stLiquidityAddOnShock;
    }

    public BigDecimal getStCurrencyShock() {
        return stCurrencyShock;
    }

    public void setStCurrencyShock(BigDecimal stCurrencyShock) {
        this.stCurrencyShock = stCurrencyShock;
    }

    public LocalDate getStActivationDate() {
        return stActivationDate;
    }

    public void setStActivationDate(LocalDate stActivationDate) {
        this.stActivationDate = stActivationDate;
    }

    public LocalDate getStDeactivationDate() {
        return stDeactivationDate;
    }

    public void setStDeactivationDate(LocalDate stDeactivationDate) {
        this.stDeactivationDate = stDeactivationDate;
    }

    public Boolean getSpikeEodTrigger() {
        return spikeEodTrigger;
    }

    public void setSpikeEodTrigger(Boolean spikeEodTrigger) {
        this.spikeEodTrigger = spikeEodTrigger;
    }

    public BigDecimal getSpikeTriggerValue() {
        return spikeTriggerValue;
    }

    public void setSpikeTriggerValue(BigDecimal spikeTriggerValue) {
        this.spikeTriggerValue = spikeTriggerValue;
    }

    public Boolean getRiskAlertTrigger() {
        return riskAlertTrigger;
    }

    public void setRiskAlertTrigger(Boolean riskAlertTrigger) {
        this.riskAlertTrigger = riskAlertTrigger;
    }

    public Integer getAlertTriggerLevel() {
        return alertTriggerLevel;
    }

    public void setAlertTriggerLevel(Integer alertTriggerLevel) {
        this.alertTriggerLevel = alertTriggerLevel;
    }

    public Boolean getTimeslotTrigger() {
        return timeslotTrigger;
    }

    public void setTimeslotTrigger(Boolean timeslotTrigger) {
        this.timeslotTrigger = timeslotTrigger;
    }

    public String getSpikeTriggerType() {
        return spikeTriggerType;
    }

    public void setSpikeTriggerType(String spikeTriggerType) {
        this.spikeTriggerType = spikeTriggerType;
    }
}