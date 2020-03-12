/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.qsmart2api.dtos.service.ServiceGDto;
import com.vm.qsmart2api.dtos.usersdto.DoctorGetDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentGDto {

    private Integer deptId;
    private String deptName;
    private int floorId;
    private Short status;
    private int orgId;
    private short deptType;
    private String deptArbName;
    private Integer pharmaType;
    private String pharmaLocation;
    private Integer pharmaIndex;
    private Short dept_Multiple_Token;
    private Integer print_waiting_token;

    private List<ServiceGDto> services = new ArrayList<>();
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

    public List<ServiceGDto> getServices() {
        return services;
    }

    public String getDeptArbName() {
        return deptArbName;
    }

    public void setDeptArbName(String deptArbName) {
        this.deptArbName = deptArbName;
    }

    public short getDeptType() {
        return deptType;
    }

    public void setDeptType(short deptType) {
        this.deptType = deptType;
    }

    public void setServices(List<ServiceGDto> services) {
        this.services = services;
    }

    public void addService(ServiceGDto serObj) {
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

    public Short getDept_Multiple_Token() {
        return dept_Multiple_Token;
    }

    public void setDept_Multiple_Token(Short dept_Multiple_Token) {
        this.dept_Multiple_Token = dept_Multiple_Token;
    }

    public Integer getPharmaType() {
        return pharmaType;
    }

    public void setPharmaType(Integer pharmaType) {
        this.pharmaType = pharmaType;
    }

    public String getPharmaLocation() {
        return pharmaLocation;
    }

    public void setPharmaLocation(String pharmaLocation) {
        this.pharmaLocation = pharmaLocation;
    }

    public Integer getPharmaIndex() {
        return pharmaIndex;
    }

    public void setPharmaIndex(Integer pharmaIndex) {
        this.pharmaIndex = pharmaIndex;
    }

    public Integer getPrint_waiting_token() {
        return print_waiting_token;
    }

    public void setPrint_waiting_token(Integer print_waiting_token) {
        this.print_waiting_token = print_waiting_token;
    }

    @Override
    public String toString() {
        return "DepartmentGDto{" + "deptId=" + deptId + ", deptName=" + deptName + ", floorId=" + floorId + ", status=" + status + ", orgId=" + orgId + ", deptType=" + deptType + ", deptArbName=" + deptArbName + ", pharmaType=" + pharmaType + ", pharmaLocation=" + pharmaLocation + ", pharmaIndex=" + pharmaIndex + ", dept_Multiple_Token=" + dept_Multiple_Token + ", print_waiting_token=" + print_waiting_token + ", services=" + services + ", doctors=" + doctors + '}';
    }

}
