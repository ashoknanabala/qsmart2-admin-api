/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.service;

/**
 *
 * @author VMHDCLAP21
 */
public class ServiceDto {

    private Integer serviceId;
    private String serviceEngName;
    private String serviceArName;
    private short serviceType;

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

    @Override
    public String toString() {
        return "ServiceDto{" + "serviceId=" + serviceId + ", serviceEngName=" + serviceEngName + ", serviceArName=" + serviceArName + '}';
    }

}
