/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Navya
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentGtDto {

    private Integer deptId;
    private String deptName;
    private Integer floorId;
    private Short status;
    private Integer orgId;
    private String deptArbName;
    private Short dept_Multiple_Token;
    private Integer deptType;
    private String pharmaLocation;
    private Integer pharmaIndex;
    private Integer pharmaType;
    private Integer print_waiting_token;

    public String getDeptArbName() {
        return deptArbName;
    }

    public void setDeptArbName(String deptArbName) {
        this.deptArbName = deptArbName;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Short getDept_Multiple_Token() {
        return dept_Multiple_Token;
    }

    public void setDept_Multiple_Token(Short dept_Multiple_Token) {
        this.dept_Multiple_Token = dept_Multiple_Token;
    }

    public String getPharmaLocation() {
        return pharmaLocation;
    }

    public void setPharmaLocation(String pharmaLocation) {
        this.pharmaLocation = pharmaLocation;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public Integer getPharmaIndex() {
        return pharmaIndex;
    }

    public void setPharmaIndex(Integer pharmaIndex) {
        this.pharmaIndex = pharmaIndex;
    }

    public Integer getPharmaType() {
        return pharmaType;
    }

    public void setPharmaType(Integer pharmaType) {
        this.pharmaType = pharmaType;
    }

    public Integer getPrint_waiting_token() {
        return print_waiting_token;
    }

    public void setPrint_waiting_token(Integer print_waiting_token) {
        this.print_waiting_token = print_waiting_token;
    }

    @Override
    public String toString() {
        return "DepartmentGtDto{" + "deptId=" + deptId + ", deptName=" + deptName + ", floorId=" + floorId + ", status=" + status + ", orgId=" + orgId + ", deptArbName=" + deptArbName + ", dept_Multiple_Token=" + dept_Multiple_Token + ", deptType=" + deptType + ", pharmaLocation=" + pharmaLocation + ", pharmaIndex=" + pharmaIndex + ", pharmaType=" + pharmaType + ", print_waiting_token=" + print_waiting_token + '}';
    }

}
