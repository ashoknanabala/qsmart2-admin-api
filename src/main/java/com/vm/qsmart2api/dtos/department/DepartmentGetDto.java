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
 * @author Phani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentGetDto {
      
    private List<DepartmentGDto> departments;

    public List<DepartmentGDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentGDto> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "DepartmentGetDto{" + "departments=" + departments + '}';
    }
    
}
