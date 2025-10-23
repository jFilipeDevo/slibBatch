package com.slib.bd.entity;

import java.time.LocalTime;

public class ConnectorParamDTO {
    private String id;
    private LocalTime finFilEau;
    private String flowReference;
    private Boolean gscp;
    private LocalTime heureMaxArrete;
    private String identification;
    private boolean clientSetup;
    private Long periodicite;
    private Long timeLag;
    private String type;
    private Integer version;
    private String flowDirection;
    private String btfInstanceName;
    private String ccp;
    private String algorithm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getFinFilEau() {
        return finFilEau;
    }

    public void setFinFilEau(LocalTime finFilEau) {
        this.finFilEau = finFilEau;
    }

    public String getFlowReference() {
        return flowReference;
    }

    public void setFlowReference(String flowReference) {
        this.flowReference = flowReference;
    }

    public Boolean getGscp() {
        return gscp;
    }

    public void setGscp(Boolean gscp) {
        this.gscp = gscp;
    }

    public LocalTime getHeureMaxArrete() {
        return heureMaxArrete;
    }

    public void setHeureMaxArrete(LocalTime heureMaxArrete) {
        this.heureMaxArrete = heureMaxArrete;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public boolean isClientSetup() {
        return clientSetup;
    }

    public void setClientSetup(boolean clientSetup) {
        this.clientSetup = clientSetup;
    }

    public Long getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(Long periodicite) {
        this.periodicite = periodicite;
    }

    public Long getTimeLag() {
        return timeLag;
    }

    public void setTimeLag(Long timeLag) {
        this.timeLag = timeLag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFlowDirection() {
        return flowDirection;
    }

    public void setFlowDirection(String flowDirection) {
        this.flowDirection = flowDirection;
    }

    public String getBtfInstanceName() {
        return btfInstanceName;
    }

    public void setBtfInstanceName(String btfInstanceName) {
        this.btfInstanceName = btfInstanceName;
    }

    public String getCcp() {
        return ccp;
    }

    public void setCcp(String ccp) {
        this.ccp = ccp;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}