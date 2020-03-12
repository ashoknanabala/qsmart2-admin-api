/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Navya
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentFloorGetDto {
    private List<DepartmentGtDto> departments;

    public DepartmentFloorGetDto() {
    }

    public DepartmentFloorGetDto(List<DepartmentGtDto> departments) {
        this.departments = departments;
    }

    public List<DepartmentGtDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentGtDto> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "DepartmentFloorGetDto{" + "departments=" + departments + '}';
    }

    
}
