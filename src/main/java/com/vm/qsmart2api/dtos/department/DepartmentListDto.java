/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sitaram
 */
public class DepartmentListDto {

    private List<DepartmentDataDto> departments = new ArrayList<>();

    public void addDept(DepartmentDataDto dept) {
        departments.add(dept);
    }

    public DepartmentListDto(List<DepartmentDataDto> departments) {
        this.departments = departments;
    }

    public List<DepartmentDataDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentDataDto> departments) {
        this.departments = departments;
    }

    public DepartmentListDto() {
    }

    @Override
    public String toString() {
        return "DepartmentListDto{" + "departments=" + departments + '}';
    }

}
    