/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author VMHDCLAP21
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeptDto {

    private Integer deptId;
    private String deptName;

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

    @Override
    public String toString() {
        return "DeptDto{" + "deptId=" + deptId + ", deptName=" + deptName + '}';
    }

}
