/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Ashok
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceGDto {
     private Integer serviceId;
    private String serviceEngName;
    private String serviceArName;
    private String servicePrefix;
    private Short status;
    private Integer deptId;
    private String deptName;
    private Integer floorId;
    private String floorName;
    private Integer orgId;
    private Short npEarlyCheckin;
    private Short npLateCheckin;
//    private String serviceLocation;
    private Integer startToken;
    private Integer endToken;
    private short serviceType;
    private String serviceColor;

    private Integer buildId;
    private String buildEngName;
    private String buildArbName;
    private Integer psTypeId;

    private String psTypeName;
    private String psTypeCode;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildEngName() {
        return buildEngName;
    }

    public void setBuildEngName(String buildEngName) {
        this.buildEngName = buildEngName;
    }

    public String getBuildArbName() {
        return buildArbName;
    }

    public void setBuildArbName(String buildArbName) {
        this.buildArbName = buildArbName;
    }

    public short getServiceType() {
        return serviceType;
    }

    public void setServiceType(short serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceEngName() {
        return serviceEngName;
    }

    public void setServiceEngName(String serviceEngName) {
        this.serviceEngName = serviceEngName;
    }

    public String getServiceArName() {
        return serviceArName;
    }

    public void setServiceArName(String serviceArName) {
        this.serviceArName = serviceArName;
    }

    public String getServicePrefix() {
        return servicePrefix;
    }

    public void setServicePrefix(String servicePrefix) {
        this.servicePrefix = servicePrefix;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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

    public String getServiceColor() {
        return serviceColor;
    }

    public void setServiceColor(String serviceColor) {
        this.serviceColor = serviceColor;
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

    public Integer getPsTypeId() {
        return psTypeId;
    }

    public void setPsTypeId(Integer psTypeId) {
        this.psTypeId = psTypeId;
    }

    public String getPsTypeName() {
        return psTypeName;
    }

    public void setPsTypeName(String psTypeName) {
        this.psTypeName = psTypeName;
    }

    public String getPsTypeCode() {
        return psTypeCode;
    }

    public void setPsTypeCode(String psTypeCode) {
        this.psTypeCode = psTypeCode;
    }

//    @Override
//    public String toString() {
//        return "ServiceGDto{" + "serviceId=" + serviceId + ", serviceEngName=" + serviceEngName + ", serviceArName=" + serviceArName + ", servicePrefix=" + servicePrefix + ", status=" + status + ", deptId=" + deptId + ", deptName=" + deptName + ", floorId=" + floorId + ", floorName=" + floorName + ", orgId=" + orgId + ", npEarlyCheckin=" + npEarlyCheckin + ", npLateCheckin=" + npLateCheckin + ", startToken=" + startToken + ", endToken=" + endToken + ", serviceType=" + serviceType + ", serviceColor=" + serviceColor + '}';
//    }
    @Override
    public String toString() {
        return "ServiceGDto{" + "serviceId=" + serviceId + ", serviceEngName=" + serviceEngName + ", serviceArName=" + serviceArName + ", servicePrefix=" + servicePrefix + ", status=" + status + ", deptId=" + deptId + ", deptName=" + deptName + ", floorId=" + floorId + ", floorName=" + floorName + ", orgId=" + orgId + ", npEarlyCheckin=" + npEarlyCheckin + ", npLateCheckin=" + npLateCheckin + ", startToken=" + startToken + ", endToken=" + endToken + ", serviceType=" + serviceType + ", serviceColor=" + serviceColor + ", buildId=" + buildId + ", buildEngName=" + buildEngName + ", buildArbName=" + buildArbName + '}';
    }

}
