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
public class DeptPharmTypeGetDto {
     private int id;
     private String pharmType;

    public DeptPharmTypeGetDto() {
    }

    public DeptPharmTypeGetDto(int id, String pharmType) {
        this.id = id;
        this.pharmType = pharmType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPharmType() {
        return pharmType;
    }

    public void setPharmType(String pharmType) {
        this.pharmType = pharmType;
    }

    @Override
    public String toString() {
        return "DeptPharmTypeGetDto{" + "id=" + id + ", pharmType=" + pharmType + '}';
    }

    
}
