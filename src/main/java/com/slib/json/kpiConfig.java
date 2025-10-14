package com.slib.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

public class kpiConfig {
    @Id
    @JsonProperty("kpi_id")
    private Long kpiId;
    @JsonProperty("kpi_name")
    private String kpiName;
    private String unit;
    @JsonProperty("config_date")
    private String configDate;
    @JsonProperty("threshold_upper_value")
    private double thresholdUpperValue;
    @JsonProperty("threshold_lower_value")
    private double thresholdLowerValue;
    @JsonProperty("target_field_window_values")
    private double targetFieldWindowValues;
    @JsonProperty("target_field_window_unit")
    private String targetFieldWindowUnit;
    private String severity;
    private int priority;
    @JsonProperty("breach_on")
    private String breachOn;
    @JsonProperty("evaluation_frequency")
    private String evaluationFrequency;

    public kpiConfig() {
        super();
    }

    public Long getKpiId() {
        return kpiId;
    }

    public void setKpiId(Long kpiId) {
        this.kpiId = kpiId;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getThresholdUpperValue() {
        return thresholdUpperValue;
    }

    public void setThresholdUpperValue(double thresholdUpperValue) {
        this.thresholdUpperValue = thresholdUpperValue;
    }

    public double getThresholdLowerValue() {
        return thresholdLowerValue;
    }

    public void setThresholdLowerValue(double thresholdLowerValue) {
        this.thresholdLowerValue = thresholdLowerValue;
    }

    public double getTargetFieldWindowValues() {
        return targetFieldWindowValues;
    }

    public void setTargetFieldWindowValues(double targetFieldWindowValues) {
        this.targetFieldWindowValues = targetFieldWindowValues;
    }

    public String getTargetFieldWindowUnit() {
        return targetFieldWindowUnit;
    }

    public void setTargetFieldWindowUnit(String targetFieldWindowUnit) {
        this.targetFieldWindowUnit = targetFieldWindowUnit;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getBreachOn() {
        return breachOn;
    }

    public void setBreachOn(String breachOn) {
        this.breachOn = breachOn;
    }

    public String getEvaluationFrequency() {
        return evaluationFrequency;
    }

    public void setEvaluationFrequency(String evaluationFrequency) {
        this.evaluationFrequency = evaluationFrequency;
    }

    public String getConfigDate() {
        return configDate;
    }

    public void setConfigDate(String configDate) {
        this.configDate = configDate;
    }
}
