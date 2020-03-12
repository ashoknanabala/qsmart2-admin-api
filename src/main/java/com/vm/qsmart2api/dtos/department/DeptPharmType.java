/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.dtos.department;

import java.util.List;

/**
 *
 * @author Bhavani
 */
public class DeptPharmType {
    private List<DeptPharmTypeGetDto> list;

    public DeptPharmType() {
    }

    public DeptPharmType(List<DeptPharmTypeGetDto> list) {
        this.list = list;
    }

    public List<DeptPharmTypeGetDto> getList() {
        return list;
    }

    public void setList(List<DeptPharmTypeGetDto> list) {
        this.list = list;
    }
     public void add(DeptPharmTypeGetDto deptPharmTypeGetDto) {
        list.add(deptPharmTypeGetDto);
    }

    @Override
    public String toString() {
        return "DeptPharmType{" + "list=" + list + '}';
    }
    
}
