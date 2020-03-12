/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.service.ServiceDataDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VMLAP25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDataDto {

    private Integer deptId;
    private String deptName;
    private int floorId;
    private Short status;
    private int orgId;
    private short deptType;
    private String deptArbName;
    private Integer print_waiting_token;

    private List<ServiceDataDto> services = new ArrayList<>();

    public List<ServiceDataDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceDataDto> services) {
        this.services = services;
    }

    public void addService(ServiceDataDto serObj) {
        services.add(serObj);
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

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public short getDeptType() {
        return deptType;
    }

    public void setDeptType(short deptType) {
        this.deptType = deptType;
    }

    public String getDeptArbName() {
        return deptArbName;
    }

    public void setDeptArbName(String deptArbName) {
        this.deptArbName = deptArbName;
    }

    public void setPrint_waiting_token(Integer print_waiting_token) {
        this.print_waiting_token = print_waiting_token;
    }

    @Override
    public String toString() {
        return "DepartmentDataDto{" + "deptId=" + deptId + ", deptName=" + deptName + ", floorId=" + floorId + ", status=" + status + ", orgId=" + orgId + ", deptType=" + deptType + ", deptArbName=" + deptArbName + ", print_waiting_token=" + print_waiting_token + ", services=" + services + '}';
    }

}
