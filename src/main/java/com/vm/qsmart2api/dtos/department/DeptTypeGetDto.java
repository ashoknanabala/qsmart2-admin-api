/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

/**
 *
 * @author Bhavani
 */
public class DeptTypeGetDto {
    private int id;
    private String deptName;
    private String deptprefix;

    public DeptTypeGetDto() {
    }

    public DeptTypeGetDto(int id, String deptName, String deptprefix) {
        this.id = id;
        this.deptName = deptName;
        this.deptprefix = deptprefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptprefix() {
        return deptprefix;
    }

    public void setDeptprefix(String deptprefix) {
        this.deptprefix = deptprefix;
    }

    @Override
    public String toString() {
        return "DeptTypeGetDto{" + "id=" + id + ", deptName=" + deptName + ", deptprefix=" + deptprefix + '}';
    }
    
}
