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
public class DeptType {
    private List<DeptTypeGetDto> list;

    public DeptType() {
    }

    public DeptType(List<DeptTypeGetDto> list) {
        this.list = list;
    }

    public List<DeptTypeGetDto> getList() {
        return list;
    }

    public void setList(List<DeptTypeGetDto> list) {
        this.list = list;
    }
    public void add(DeptTypeGetDto deptTypeGetDto) {
        list.add(deptTypeGetDto);
    }


    @Override
    public String toString() {
        return "DeptType{" + "list=" + list + '}';
    }
    
}
