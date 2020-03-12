/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.usersdto.DoctorGetDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VMLAP25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceDataDto {

    private Integer serviceId;
    private String serviceEngName;
    private String serviceArName;
    private String servicePrefix;
    private Short status;
    private Integer deptId;
    private Integer floorId;
    private String floorName;
    private Integer orgId;
    private Short npEarlyCheckin;
    private Short npLateCheckin;
    private Integer startToken;
    private Integer endToken;
    private short serviceType;

    private List<DoctorGetDto> doctors = new ArrayList<>();

    public void addDoctor(DoctorGetDto dctrDto) {
        doctors.add(dctrDto);
    }

    public List<DoctorGetDto> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorGetDto> doctors) {
        this.doctors = doctors;
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

    public short getServiceType() {
        return serviceType;
    }

    public void setServiceType(short serviceType) {
        this.serviceType = serviceType;
    }

}
