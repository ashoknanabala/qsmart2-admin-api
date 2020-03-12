/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sitaram
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceUpdateDto {

    @ApiModelProperty(required = true, notes = "serviceId should't be empty", example = "1")
    @NotNull(message = "{service.dto.serviceId}")
    private Integer serviceId;

    @ApiModelProperty(required = true, notes = "deptId  should't be empty", example = "1")
    @NotNull(message = "{service.dto.deptId}")
    private Integer deptId;

    @ApiModelProperty(required = true, notes = "floorId name should't be empty", example = "1")
    @NotNull(message = "{service.dto.floorId}")
    private Integer floorId;

    @ApiModelProperty(required = true, notes = "orgId name should't be empty", example = "1")
    @NotNull(message = "{service.dto.orgId}")
    private Integer orgId;

    @ApiModelProperty(required = true, notes = "serviceName should't be empty and size must be 50 characters", example = "deptServ")
    @NotNull(message = "{service.dto.serviceName}")
    private String serviceEngName;

    @ApiModelProperty(required = true, notes = "servicePrefix should't be empty and size must be 10 characters", example = "SA")
    @NotNull(message = "{service.dto.servicePrefix}")
    private String servicePrefix;

    @ApiModelProperty(required = false, notes = "startTime should't be empty", example = "1")
    @NotNull(message = "{service.dto.startToken}")
    private Integer startToken;

    @ApiModelProperty(required = false, notes = "endTime should't be empty", example = "10")
    @NotNull(message = "{service.dto.endToken}")
    private Integer endToken;

    @ApiModelProperty(required = true, notes = "serviceArName is optional and size must be 50 characters ", example = "الخدمات")
    //@NotNull(message = "{service.dto.serviceName}")
    private String serviceArName;

//    @ApiModelProperty(required = true, notes = "serviceLocation should't be empty and size must be 50 characters ", example = "Hyd")
//    @NotNull(message = "{service.dto.serviceLocation}")
//    private String serviceLocation;
    @ApiModelProperty(required = true, notes = "npEarlyCheckin should't be empty", example = "30")
    @NotNull(message = "{service.dto.npEarlyCheckin}")
    private Short npEarlyCheckin;

    @ApiModelProperty(required = true, notes = "npLateCheckin should't be empty", example = "30")
    @NotNull(message = "{service.dto.npLateCheckin}")
    private Short npLateCheckin;

    @ApiModelProperty(required = true, notes = "patientEarlyCheckin is optional", example = "30")
//    @NotNull(message = "{service.dto.serviceLocation}")
    private Short patientEarlyCheckin;

    @ApiModelProperty(required = true, notes = "patientLateCheckin is optional", example = "30")
//    @NotNull(message = "{service.dto.serviceLocation}")
    private Short patientLateCheckin;

    @ApiModelProperty(required = false, notes = "serviceColor is optional", example = "0")
    private String serviceColor;
 
//    @ApiModelProperty(required = true, notes = "psTypeId should't be empty", example = "1")
//    @NotNull(message = "{service.dto.psTypeId}")
    private Integer psTypeId;
    
    private Short serviceType;
    

    public String getServiceColor() {
        return serviceColor;
    }

    public void setServiceColor(String serviceColor) {
        this.serviceColor = serviceColor;
    }

    public String getServiceEngName() {
        return serviceEngName;
    }

    public void setServiceEngName(String serviceEngName) {
        this.serviceEngName = serviceEngName;
    }

    public Integer getStartToken() {
        return startToken;
    }

    public void setStartToken(Integer startToken) {
        this.startToken = startToken;
    }

    public Integer getEndToken() {
        return endToken;
    }

    public void setEndToken(Integer endToken) {
        this.endToken = endToken;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getServicePrefix() {
        return servicePrefix;
    }

    public void setServicePrefix(String servicePrefix) {
        this.servicePrefix = servicePrefix;
    }

    public String getServiceArName() {
        return serviceArName;
    }

    public void setServiceArName(String serviceArName) {
        this.serviceArName = serviceArName;
    }

    public Short getNpEarlyCheckin() {
        return npEarlyCheckin;
    }

    public void setNpEarlyCheckin(Short npEarlyCheckin) {
        this.npEarlyCheckin = npEarlyCheckin;
    }

    public Short getNpLateCheckin() {
        return npLateCheckin;
    }

    public void setNpLateCheckin(Short npLateCheckin) {
        this.npLateCheckin = npLateCheckin;
    }

    public Short getPatientEarlyCheckin() {
        return patientEarlyCheckin;
    }

    public void setPatientEarlyCheckin(Short patientEarlyCheckin) {
        this.patientEarlyCheckin = patientEarlyCheckin;
    }

    public Short getPatientLateCheckin() {
        return patientLateCheckin;
    }

    public void setPatientLateCheckin(Short patientLateCheckin) {
        this.patientLateCheckin = patientLateCheckin;
    }

    public Integer getPsTypeId() {
        return psTypeId;
    }

    public void setPsTypeId(Integer psTypeId) {
        this.psTypeId = psTypeId;
    }

    public Short getServiceType() {
        return serviceType;
    }

    public void setServiceType(Short serviceType) {
        this.serviceType = serviceType;
    }
    
    
    

    @Override
    public String toString() {
        return "ServiceUpdateDto{" + "serviceId=" + serviceId + ", deptId=" + deptId + ", floorId=" + floorId + ", orgId=" + orgId + ", serviceEngName=" + serviceEngName + ", servicePrefix=" + servicePrefix + ", startToken=" + startToken + ", endToken=" + endToken + ", serviceArName=" + serviceArName + ", npEarlyCheckin=" + npEarlyCheckin + ", npLateCheckin=" + npLateCheckin + ", patientEarlyCheckin=" + patientEarlyCheckin + ", patientLateCheckin=" + patientLateCheckin + ", serviceColor=" + serviceColor + '}';
    }

    
 
}
